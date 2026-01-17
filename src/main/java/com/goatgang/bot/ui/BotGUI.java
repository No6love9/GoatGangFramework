package com.goatgang.bot.ui;

import javax.swing.*;
import java.awt.*;

public class BotGUI {
    private final JFrame frame;
    
    // Configuration values (could be moved to a Config class)
    private double diceWinChance = 0.55;
    private long minBet = 1000;
    private long maxBet = 10000000;
    private String autoChatMessage = "Join GoatGang for the best OSRS games!";
    private int autoChatInterval = 5000;

    public BotGUI() {
        frame = new JFrame("GoatGang Framework - Control Panel");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        JTabbedPane tabbedPane = new JTabbedPane();

        // Overview Tab
        tabbedPane.addTab("Overview", createOverviewPanel());
        
        // Dice Game Config Tab
        tabbedPane.addTab("Dice Game", createDiceConfigPanel());
        
        // Flower Poker Config Tab
        tabbedPane.addTab("Flower Poker", createFlowerPokerConfigPanel());
        
        // AutoChatter Config Tab
        tabbedPane.addTab("AutoChatter", createAutoChatterPanel());

        frame.add(tabbedPane);
    }

    private JPanel createOverviewPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("GoatGang Framework v1.0", SwingConstants.CENTER));
        panel.add(new JLabel("Status: Running", SwingConstants.CENTER));
        panel.add(new JLabel("Active Games: 0", SwingConstants.CENTER));
        return panel;
    }

    private JPanel createDiceConfigPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Win Chance (0.0 - 1.0):"), gbc);
        
        gbc.gridx = 1;
        JTextField winChanceField = new JTextField(String.valueOf(diceWinChance));
        panel.add(winChanceField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Min Bet:"), gbc);
        
        gbc.gridx = 1;
        JTextField minBetField = new JTextField(String.valueOf(minBet));
        panel.add(minBetField, gbc);

        JButton saveButton = new JButton("Save Dice Settings");
        saveButton.addActionListener(e -> {
            try {
                diceWinChance = Double.parseDouble(winChanceField.getText());
                minBet = Long.parseLong(minBetField.getText());
                JOptionPane.showMessageDialog(frame, "Dice settings saved!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input format.");
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        return panel;
    }

    private JPanel createFlowerPokerConfigPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Max Bet:"), gbc);
        
        gbc.gridx = 1;
        JTextField maxBetField = new JTextField(String.valueOf(maxBet));
        panel.add(maxBetField, gbc);

        JCheckBox allowJackpot = new JCheckBox("Enable Rainbow Jackpot", true);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        panel.add(allowJackpot, gbc);

        JButton saveButton = new JButton("Save Flower Poker Settings");
        saveButton.addActionListener(e -> {
            try {
                maxBet = Long.parseLong(maxBetField.getText());
                JOptionPane.showMessageDialog(frame, "Flower Poker settings saved!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input format.");
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        return panel;
    }

    private JPanel createAutoChatterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Message:"), gbc);
        
        gbc.gridx = 1;
        JTextField msgField = new JTextField(autoChatMessage);
        panel.add(msgField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Interval (ms):"), gbc);
        
        gbc.gridx = 1;
        JTextField intervalField = new JTextField(String.valueOf(autoChatInterval));
        panel.add(intervalField, gbc);

        JButton saveButton = new JButton("Update AutoChatter");
        saveButton.addActionListener(e -> {
            autoChatMessage = msgField.getText();
            try {
                autoChatInterval = Integer.parseInt(intervalField.getText());
                JOptionPane.showMessageDialog(frame, "AutoChatter updated!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid interval.");
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        return panel;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    // Getters for settings
    public double getDiceWinChance() { return diceWinChance; }
    public long getMinBet() { return minBet; }
    public long getMaxBet() { return maxBet; }
    public String getAutoChatMessage() { return autoChatMessage; }
    public int getAutoChatInterval() { return autoChatInterval; }
}
