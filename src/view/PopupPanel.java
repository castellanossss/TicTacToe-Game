package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PopupPanel extends JPanel {
    private JPanel miniPanel;
    private JLabel iconLabel, textLabel;
    private JButton menuBtn, okBtn;
    private ActionListener actionListener;
    private Color white = new Color(255, 255, 255);

    public PopupPanel(ActionListener actionListener, Color bgColor, Color brdColor, ImageIcon icon, String message) {
        this.actionListener = actionListener;

        setBounds(61, 130, 277, 139);
        setLayout(null);
        setBackground(bgColor);
        setBorder(BorderFactory.createLineBorder(brdColor, 5));

        miniPanel = new JPanel();
        miniPanel.setBounds(49, 17, 180, 68);
        miniPanel.setLayout(null);
        miniPanel.setBackground(white);
        miniPanel.setBorder(BorderFactory.createLineBorder(brdColor, 3));

        iconLabel = new JLabel(icon);
        iconLabel.setBounds(12, 18, 32, 32);

        miniPanel.add(iconLabel);

        textLabel = new JLabel(message);
        textLabel.setBounds(50, 18, 120, 32);
        textLabel.setFont(new Font("Inter", Font.BOLD, 16));
        textLabel.setBackground(white);
        textLabel.setForeground(Color.BLACK);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.CENTER);

        miniPanel.add(textLabel);

        menuBtn = new JButton("Menu");
        menuBtn.setBounds(40, 98, 78, 25);
        menuBtn.setFont(new Font("Inter", Font.BOLD, 14));
        menuBtn.setBackground(white);
        menuBtn.setForeground(Color.BLACK);
        menuBtn.setBorder(BorderFactory.createLineBorder(brdColor, 3));
        menuBtn.setFocusable(false);

        menuBtn.addActionListener(actionListener);
        menuBtn.setActionCommand("menuBtn");

        menuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuBtn.setBackground(brdColor);
                menuBtn.setForeground(white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuBtn.setBackground(white);
                menuBtn.setForeground(Color.BLACK);
            }
        });

        okBtn = new JButton("Ok");
        okBtn.setBounds(158, 98, 78, 25);
        okBtn.setFont(new Font("Inter", Font.BOLD, 14));
        okBtn.setBackground(white);
        okBtn.setForeground(Color.BLACK);
        okBtn.setBorder(BorderFactory.createLineBorder(brdColor, 3));
        okBtn.setFocusable(false);

        okBtn.addActionListener(actionListener);
        okBtn.setActionCommand("okBtn");

        okBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okBtn.setBackground(brdColor);
                okBtn.setForeground(white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                okBtn.setBackground(white);
                okBtn.setForeground(Color.BLACK);
            }
        });

        add(miniPanel);
        add(menuBtn);
        add(okBtn);

        setVisible(false);
    }

}
