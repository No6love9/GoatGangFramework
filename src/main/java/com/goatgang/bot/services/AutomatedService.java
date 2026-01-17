package com.goatgang.bot.services;

public interface AutomatedService {
    void execute();
    boolean isConditionMet();
    String getName();
}
