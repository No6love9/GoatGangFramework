package com.goatgang.bot.core;

import com.goatgang.bot.games.FlowerPoker;
import com.goatgang.bot.services.EconomyService;
import com.goatgang.bot.ui.BotGUI;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Timer;

import javax.swing.*;
import java.awt.*;

@ScriptManifest(
    author = "GoatGang",
    name = "GoatGang Framework",
    version = 1.0,
    description = "A robust OSRS bot framework with integrated games and automated services.",
    category = Category.MISC
)
public class GoatGangBot extends AbstractScript {

    private EconomyService economyService;
    private BotGUI gui;
    private Timer runtime;
    private String status = "Initializing...";

    @Override
    public void onStart() {
        log("GoatGang Framework Starting...");
        economyService = EconomyService.getInstance();
        runtime = new Timer();
        
        SwingUtilities.invokeLater(() -> {
            gui = new BotGUI();
            gui.show();
        });
        
        status = "Running";
    }

    @Override
    public int onLoop() {
        if (Players.getLocal().isAnimating()) {
            status = "Animating...";
        } else {
            status = "Idle";
        }
        
        return 600;
    }

    @Override
    public void onExit() {
        log("GoatGang Framework Shutting Down...");
        if (gui != null) {
            gui.hide();
        }
    }

    @Override
    public void onPaint(Graphics2D g) {
        // Background
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(5, 5, 200, 100);
        
        // Border
        g.setColor(new Color(255, 215, 0)); // Gold color
        g.drawRect(5, 5, 200, 100);
        
        // Text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("GoatGang Framework v1.0", 15, 25);
        g.drawString("Runtime: " + runtime.formatTime(), 15, 45);
        g.drawString("Status: " + status, 15, 65);
        g.drawString("Balance: " + economyService.getBalance(Players.getLocal().getID()) + " GP", 15, 85);
    }
}
