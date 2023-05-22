package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlayerInfoScreen extends JPanel {
    private JPanel panel1;
    private JTextField titleTxtField, nicknameTxtField, symbolTxtField;
    private JTextArea nicknameTxtArea;
    private JComboBox symbolComboBox;
    private JButton startBtn, backBtn;
    private Color orange = new Color(255, 138, 0);
    private Color white = new Color(255, 255, 255);

    public PlayerInfoScreen(ActionListener actionListener) {

        setLayout(null);
        setBounds(0, 0, 400, 400);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(orange, 10));

        titleTxtField = new JTextField();
        titleTxtField.setBounds(53, 39, 293, 71);
        titleTxtField.setText("PLAYER INFO");
        titleTxtField.setHorizontalAlignment(JTextField.CENTER);
        titleTxtField.setFont(new Font("Inter", Font.BOLD, 32));
        titleTxtField.setBackground(Color.WHITE);
        titleTxtField.setForeground(Color.BLACK);
        titleTxtField.setBorder(BorderFactory.createLineBorder(orange, 10));
        titleTxtField.setEditable(false);

        add(titleTxtField);

        nicknameTxtField = new JTextField();
        nicknameTxtField.setBounds(39, 156, 148, 37);
        nicknameTxtField.setText("Nickname");
        nicknameTxtField.setHorizontalAlignment(JTextField.CENTER);
        nicknameTxtField.setFont(new Font("Inter", Font.BOLD, 20));
        nicknameTxtField.setBackground(Color.WHITE);
        nicknameTxtField.setForeground(Color.BLACK);
        nicknameTxtField.setBorder(BorderFactory.createLineBorder(orange, 5));
        nicknameTxtField.setEditable(false);

        add(nicknameTxtField);

        nicknameTxtArea = new JTextArea();
        nicknameTxtArea.setBounds(216, 156, 148, 37);
        nicknameTxtArea.setFont(new Font("Inter", Font.BOLD, 18));
        nicknameTxtArea.setBackground(Color.WHITE);
        nicknameTxtArea.setForeground(Color.BLACK);
        nicknameTxtArea.setBorder(BorderFactory.createLineBorder(orange, 5));

        add(nicknameTxtArea);

        symbolTxtField = new JTextField();
        symbolTxtField.setBounds(39, 228, 148, 37);
        symbolTxtField.setText("Figure");
        symbolTxtField.setHorizontalAlignment(JTextField.CENTER);
        symbolTxtField.setFont(new Font("Inter", Font.BOLD, 20));
        symbolTxtField.setBackground(Color.WHITE);
        symbolTxtField.setForeground(Color.BLACK);
        symbolTxtField.setBorder(BorderFactory.createLineBorder(orange, 5));
        symbolTxtField.setEditable(false);

        add(symbolTxtField);

        String[] symbol = {"X", "O"};

        symbolComboBox = new JComboBox(symbol);
        symbolComboBox.setBounds(216, 228, 148, 37);
        symbolComboBox.setFont(new Font("Inter", Font.BOLD, 16));
        symbolComboBox.setBackground(Color.WHITE);
        symbolComboBox.setForeground(Color.BLACK);
        symbolComboBox.setBorder(BorderFactory.createLineBorder(orange, 5));
        symbolComboBox.setFocusable(false);

        add(symbolComboBox);

        backBtn = new JButton();
        backBtn.setBounds(63, 310, 99, 37);
        backBtn.setText("Back");
        backBtn.setFont(new Font("Inter", Font.BOLD, 20));
        backBtn.setBackground(Color.WHITE);
        backBtn.setForeground(Color.BLACK);
        backBtn.setBorder(BorderFactory.createLineBorder(orange, 6));
        backBtn.setFocusable(false);

        backBtn.addActionListener(actionListener);
        backBtn.setActionCommand("backBtn");

        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtn.setBackground(orange);
                backBtn.setForeground(white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtn.setBackground(white);
                backBtn.setForeground(Color.BLACK);
            }
        });

        add(backBtn);

        startBtn = new JButton();
        startBtn.setBounds(237, 310, 99, 37);
        startBtn.setText("Start");
        startBtn.setFont(new Font("Inter", Font.BOLD, 20));
        startBtn.setBackground(Color.WHITE);
        startBtn.setForeground(Color.BLACK);
        startBtn.setBorder(BorderFactory.createLineBorder(orange, 6));
        startBtn.setFocusable(false);

        startBtn.addActionListener(actionListener);
        startBtn.setActionCommand("startBtn");

        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startBtn.setBackground(orange);
                startBtn.setForeground(white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                startBtn.setBackground(white);
                startBtn.setForeground(Color.BLACK);
            }
        });

        add(startBtn);
        this.setVisible(false);
    }

    public String getNickname() {
        return nicknameTxtArea.getText();
    }

    public String getSymbol() {
        return symbolComboBox.getSelectedItem().toString();
    }

    public void resetPlayerInfo() {
        nicknameTxtArea.setText("");
        symbolComboBox.setSelectedIndex(0);
    }


}
