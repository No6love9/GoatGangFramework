package com.goatgang.bot.ui;

import javax.swing.*;
import java.awt.*;

public class BotGUI {
    private final JFrame frame;

    public BotGUI() {
        frame = new JFrame("GoatGang Framework");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("GoatGang Framework Control Panel", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Status: Running"));
        frame.add(centerPanel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close GUI");
        closeButton.addActionListener(e -> frame.setVisible(false));
        frame.add(closeButton, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
}
