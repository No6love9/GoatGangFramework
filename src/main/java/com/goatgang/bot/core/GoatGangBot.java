package com.goatgang.bot.core;

import com.goatgang.bot.games.FlowerPoker;
import com.goatgang.bot.services.EconomyService;
import com.goatgang.bot.services.AutoChatter;
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
    version = 1.1,
    description = "A robust OSRS bot framework with integrated games and automated services.",
    category = Category.MISC
)
public class GoatGangBot extends AbstractScript {

    private EconomyService economyService;
    private BotGUI gui;
    private AutoChatter autoChatter;
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
            
            // Initialize AutoChatter with GUI defaults
            autoChatter = new AutoChatter(gui.getAutoChatMessage(), gui.getAutoChatInterval());
        });
        
        status = "Running";
    }

    @Override
    public int onLoop() {
        if (gui != null && autoChatter != null) {
            // Update AutoChatter settings from GUI in real-time
            // (In a real scenario, you might use a listener or check if changed)
            // For simplicity, we'll just execute it
            autoChatter.execute();
        }

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
        g.fillRect(5, 5, 220, 120);
        
        // Border
        g.setColor(new Color(255, 215, 0)); // Gold color
        g.drawRect(5, 5, 220, 120);
        
        // Text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("GoatGang Framework v1.1", 15, 25);
        g.drawString("Runtime: " + runtime.formatTime(), 15, 45);
        g.drawString("Status: " + status, 15, 65);
        g.drawString("Balance: " + economyService.getBalance(Players.getLocal().getID()) + " GP", 15, 85);
        
        if (gui != null) {
            g.drawString("Dice Win Chance: " + (gui.getDiceWinChance() * 100) + "%", 15, 105);
        }
    }
}
