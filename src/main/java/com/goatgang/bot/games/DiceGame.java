package com.goatgang.bot.games;

import java.util.Random;

public class DiceGame {
    private static final Random random = new Random();

    public static boolean roll(double winChance) {
        return random.nextDouble() < winChance;
    }

    public static int rollDie() {
        return random.nextInt(100) + 1;
    }
}
