package com.goatgang.bot.utils;

public class BetParser {
    public static long parse(String betStr) {
        try {
            betStr = betStr.toLowerCase().trim();
            long multiplier = 1;
            if (betStr.endsWith("k")) {
                multiplier = 1000;
                betStr = betStr.substring(0, betStr.length() - 1);
            } else if (betStr.endsWith("m")) {
                multiplier = 1000000;
                betStr = betStr.substring(0, betStr.length() - 1);
            } else if (betStr.endsWith("b")) {
                multiplier = 1000000000;
                betStr = betStr.substring(0, betStr.length() - 1);
            }
            return (long) (Double.parseDouble(betStr) * multiplier);
        } catch (Exception e) {
            return -1;
        }
    }
}
