package com.goatgang.bot.services;

import java.util.HashMap;
import java.util.Map;

public class EconomyService {
    private static EconomyService instance;
    private final Map<Long, Long> balances = new HashMap<>();

    private EconomyService() {}

    public static EconomyService getInstance() {
        if (instance == null) {
            instance = new EconomyService();
        }
        return instance;
    }

    public long getBalance(long userId) {
        return balances.getOrDefault(userId, 1000L);
    }

    public void updateBalance(long userId, long amount) {
        balances.put(userId, getBalance(userId) + amount);
    }

    public boolean canAfford(long userId, long amount) {
        return getBalance(userId) >= amount;
    }
}
