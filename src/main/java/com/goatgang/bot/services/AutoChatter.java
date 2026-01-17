package com.goatgang.bot.services;

import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.utilities.Timer;

public class AutoChatter implements AutomatedService {
    private final String message;
    private final int interval;
    private final Timer timer;

    public AutoChatter(String message, int intervalMs) {
        this.message = message;
        this.interval = intervalMs;
        this.timer = new Timer();
    }

    @Override
    public void execute() {
        if (isConditionMet()) {
            Keyboard.type(message, true);
            timer.reset();
        }
    }

    @Override
    public boolean isConditionMet() {
        return timer.elapsed() >= interval;
    }

    @Override
    public String getName() {
        return "AutoChatter";
    }
}
