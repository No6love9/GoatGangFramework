package com.goatgang.bot.games;

import java.util.*;

public class FlowerPoker {
    private static final String[] FLOWERS = {"Red", "Blue", "Yellow", "Purple", "Orange", "Mixed", "Black", "White"};
    
    public enum HandRank {
        NONE(0, "None"),
        PAIR(1, "One Pair"),
        TWO_PAIR(2, "Two Pair"),
        THREE_OF_A_KIND(3, "Three of a Kind"),
        FULL_HOUSE(4, "Full House"),
        FOUR_OF_A_KIND(5, "Four of a Kind"),
        FIVE_OF_A_KIND(6, "Five of a Kind"),
        RAINBOW(7, "Rainbow Hand");

        private final int value;
        private final String name;

        HandRank(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() { return value; }
        public String getName() { return name; }
    }

    public static class HandResult {
        public final HandRank rank;
        public final List<String> hand;

        public HandResult(HandRank rank, List<String> hand) {
            this.rank = rank;
            this.hand = hand;
        }
    }

    public static HandResult evaluateHand(List<String> hand) {
        Map<String, Integer> counts = new HashMap<>();
        for (String flower : hand) {
            counts.put(flower, counts.getOrDefault(flower, 0) + 1);
        }

        int maxCount = 0;
        for (int count : counts.values()) {
            maxCount = Math.max(maxCount, count);
        }

        if (counts.size() == 5) return new HandResult(HandRank.RAINBOW, hand);
        if (maxCount == 5) return new HandResult(HandRank.FIVE_OF_A_KIND, hand);
        if (maxCount == 4) return new HandResult(HandRank.FOUR_OF_A_KIND, hand);
        
        if (maxCount == 3) {
            if (counts.size() == 2) return new HandResult(HandRank.FULL_HOUSE, hand);
            return new HandResult(HandRank.THREE_OF_A_KIND, hand);
        }
        
        if (maxCount == 2) {
            if (counts.size() == 3) return new HandResult(HandRank.TWO_PAIR, hand);
            return new HandResult(HandRank.PAIR, hand);
        }

        return new HandResult(HandRank.NONE, hand);
    }

    public static List<String> generateHand() {
        List<String> hand = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            hand.add(FLOWERS[rand.nextInt(FLOWERS.length)]);
        }
        return hand;
    }
}
