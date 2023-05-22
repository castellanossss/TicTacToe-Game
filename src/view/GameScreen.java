package view;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameScreen extends JPanel {
    private JPanel panel1, panelGame, panel2, panel3;
    private JTextField titleTxtFieldTab2, devName, devCode, devFaculty, devSchool, devSemester;
    private JLabel playerLabelField, cpuLabelField, playerLabel, cpuLabel,
            rivalLabel1, rivalLabel2, rivalLabel3, nicknameTitleFieldTab2, symbolTitleFieldTab2, collegeLabel;
    private JTabbedPane tabbedPane;
    private JButton[][] buttons;
    private ActionListener actionListener;
    private Color orange = new Color(255, 138, 0);
    private Color white = new Color(255, 255, 255);

    public GameScreen(ActionListener actionListener) {
        super();
        this.actionListener = actionListener;
        initializeDefaults();
    }

    private void initializeDefaults() {
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setVisible(false);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(white);
        panel1.setBorder(BorderFactory.createLineBorder(orange, 10));

        playerLabel = new JLabel();
        playerLabel.setOpaque(true);
        playerLabel.setBounds(32, 35, 149, 29);
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerLabel.setFont(new Font("Inter", Font.BOLD, 14));
        playerLabel.setBackground(orange);
        playerLabel.setForeground(white);
        playerLabel.setBorder(BorderFactory.createLineBorder(orange, 3));

        panel1.add(playerLabel);

        cpuLabel = new JLabel();
        cpuLabel.setBounds(213, 35, 149, 29);
        cpuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpuLabel.setVerticalAlignment(SwingConstants.CENTER);
        cpuLabel.setFont(new Font("Inter", Font.BOLD, 14));
        cpuLabel.setBackground(white);
        cpuLabel.setForeground(Color.BLACK);
        cpuLabel.setBorder(BorderFactory.createLineBorder(orange, 3));

        panel1.add(cpuLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 94, 395, 4);
        separator.setBackground(orange);
        separator.setForeground(orange);
        separator.setBorder(BorderFactory.createLineBorder(orange, 4));

        panel1.add(separator);

        panelGame = new JPanel();
        panelGame.setLayout(new GridLayout(3, 3));
        panelGame.setBounds(85, 116, 225, 225);
        panelGame.setBackground(white);
        panelGame.setBorder(BorderFactory.createLineBorder(orange, 3));

        panel1.add(panelGame);

        buttons = new JButton[3][3];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFocusable(false);
                buttons[i][j].setFont(new Font("Inter", Font.BOLD, 40));
                buttons[i][j].setBackground(white);
                buttons[i][j].setForeground(Color.BLACK);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(orange, 2));

                buttons[i][j].addActionListener(actionListener);
                buttons[i][j].setActionCommand("button" + i + j);

                panelGame.add(buttons[i][j]);
            }
        }

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(white);
        panel2.setBorder(BorderFactory.createLineBorder(orange, 10));

        titleTxtFieldTab2 = new JTextField();
        titleTxtFieldTab2.setBounds(51, 29, 293, 71);
        titleTxtFieldTab2.setText("Player Data");
        titleTxtFieldTab2.setHorizontalAlignment(SwingConstants.CENTER);
        titleTxtFieldTab2.setFont(new Font("Inter", Font.BOLD, 36));
        titleTxtFieldTab2.setBackground(Color.WHITE);
        titleTxtFieldTab2.setForeground(Color.BLACK);
        titleTxtFieldTab2.setEditable(false);
        titleTxtFieldTab2.setBorder(BorderFactory.createLineBorder(orange, 5));

        panel2.add(titleTxtFieldTab2);

        nicknameTitleFieldTab2 = new JLabel();
        nicknameTitleFieldTab2.setBounds(33, 129, 148, 37);
        nicknameTitleFieldTab2.setText("Nickname");
        nicknameTitleFieldTab2.setHorizontalAlignment(SwingConstants.CENTER);
        nicknameTitleFieldTab2.setFont(new Font("Inter", Font.BOLD, 20));
        nicknameTitleFieldTab2.setBackground(Color.WHITE);
        nicknameTitleFieldTab2.setForeground(Color.BLACK);
        nicknameTitleFieldTab2.setBorder(BorderFactory.createLineBorder(orange, 5));

        panel2.add(nicknameTitleFieldTab2);

        symbolTitleFieldTab2 = new JLabel();
        symbolTitleFieldTab2.setBounds(33, 195, 148, 37);
        symbolTitleFieldTab2.setText("Figure");
        symbolTitleFieldTab2.setHorizontalAlignment(SwingConstants.CENTER);
        symbolTitleFieldTab2.setFont(new Font("Inter", Font.BOLD, 20));
        symbolTitleFieldTab2.setBackground(Color.WHITE);
        symbolTitleFieldTab2.setForeground(Color.BLACK);
        symbolTitleFieldTab2.setBorder(BorderFactory.createLineBorder(orange, 5));

        panel2.add(symbolTitleFieldTab2);

        playerLabelField = new JLabel();
        playerLabelField.setBounds(214, 129, 148, 37);
        playerLabelField.setHorizontalAlignment(SwingConstants.CENTER);
        playerLabelField.setFont(new Font("Inter", Font.BOLD, 16));
        playerLabelField.setBackground(Color.WHITE);
        playerLabelField.setForeground(Color.BLACK);
        playerLabelField.setBorder(BorderFactory.createLineBorder(orange, 5));

        panel2.add(playerLabelField);

        cpuLabelField = new JLabel();
        cpuLabelField.setBounds(214, 195, 148, 37);
        cpuLabelField.setHorizontalAlignment(SwingConstants.CENTER);
        cpuLabelField.setFont(new Font("Inter", Font.BOLD, 18));
        cpuLabelField.setBackground(Color.WHITE);
        cpuLabelField.setForeground(Color.BLACK);
        cpuLabelField.setBorder(BorderFactory.createLineBorder(orange, 5));

        panel2.add(cpuLabelField);

        rivalLabel1 = new JLabel("Playing against...");
        rivalLabel1.setBounds(88, 257, 220, 32);
        rivalLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        rivalLabel1.setFont(new Font("Inter", Font.BOLD, 25));
        rivalLabel1.setBackground(Color.WHITE);
        rivalLabel1.setForeground(Color.BLACK);

        panel2.add(rivalLabel1);

        rivalLabel2 = new JLabel("CPU");
        rivalLabel2.setBounds(140, 300, 58, 32);
        rivalLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        rivalLabel2.setFont(new Font("Inter", Font.BOLD, 25));
        rivalLabel2.setBackground(Color.WHITE);
        rivalLabel2.setForeground(Color.BLACK);

        panel2.add(rivalLabel2);

        rivalLabel3 = new JLabel();
        rivalLabel3.setBounds(205, 299, 32, 32);
        rivalLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        rivalLabel3.setFont(new Font("Inter", Font.BOLD, 20));
        rivalLabel3.setBackground(Color.WHITE);
        rivalLabel3.setForeground(Color.BLACK);

        ImageIcon icon = new ImageIcon("icons/ai.png");
        rivalLabel3.setIcon(icon);

        panel2.add(rivalLabel3);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(white);
        panel3.setBorder(BorderFactory.createLineBorder(orange, 10));

        devName = new JTextField();
        devName.setBounds(26, 14, 344, 41);
        devName.setFont(new Font("Inter", Font.BOLD, 16));
        devName.setBackground(white);
        devName.setForeground(Color.BLACK);
        devName.setHorizontalAlignment(SwingConstants.CENTER);
        devName.setEditable(false);
        devName.setBorder(BorderFactory.createEmptyBorder());

        panel3.add(devName);

        devCode = new JTextField();
        devCode.setBounds(26, 64, 344, 41);
        devCode.setFont(new Font("Inter", Font.BOLD, 16));
        devCode.setBackground(white);
        devCode.setForeground(Color.BLACK);
        devCode.setHorizontalAlignment(SwingConstants.CENTER);
        devCode.setEditable(false);
        devCode.setBorder(BorderFactory.createEmptyBorder());

        panel3.add(devCode);

        devFaculty = new JTextField();
        devFaculty.setBounds(26, 114, 344, 41);
        devFaculty.setFont(new Font("Inter", Font.BOLD, 16));
        devFaculty.setBackground(white);
        devFaculty.setForeground(Color.BLACK);
        devFaculty.setHorizontalAlignment(SwingConstants.CENTER);
        devFaculty.setEditable(false);
        devFaculty.setBorder(BorderFactory.createEmptyBorder());

        panel3.add(devFaculty);

        devSchool = new JTextField();
        devSchool.setBounds(16, 164, 365, 41);
        devSchool.setFont(new Font("Inter", Font.BOLD, 15));
        devSchool.setBackground(white);
        devSchool.setForeground(Color.BLACK);
        devSchool.setHorizontalAlignment(SwingConstants.CENTER);
        devSchool.setEditable(false);
        devSchool.setBorder(BorderFactory.createEmptyBorder());

        panel3.add(devSchool);

        devSemester = new JTextField();
        devSemester.setBounds(26, 214, 344, 41);
        devSemester.setFont(new Font("Inter", Font.BOLD, 16));
        devSemester.setBackground(white);
        devSemester.setForeground(Color.BLACK);
        devSemester.setHorizontalAlignment(SwingConstants.CENTER);
        devSemester.setEditable(false);
        devSemester.setBorder(BorderFactory.createEmptyBorder());

        panel3.add(devSemester);

        collegeLabel = new JLabel();
        collegeLabel.setBounds(98, 253, 200, 94);

        panel3.add(collegeLabel);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, 0, 400, 400);

        tabbedPane.add("Board Game", panel1);
        tabbedPane.add("Player Info", panel2);
        tabbedPane.add("Developer", panel3);

        add(tabbedPane);
    }

    public void setPlayerLabel(String text) {
        playerLabel.setText(text);
    }

    public void setCpuLabel(String text) {
        cpuLabel.setText(text);
    }

    public void setButton(int i, int j, String text) {
        buttons[i][j].setText(text);
    }

    public void disableCpuButton(int i, int j) {
        buttons[i][j].setEnabled(false);
    }


    public void disableButtons() {
        for (JButton[] button : buttons) {
            for (JButton jButton : button) {
                jButton.setEnabled(false);
                jButton.setUI(new MetalButtonUI() {
                    protected Color getDisabledTextColor() {
                        return Color.BLACK;
                    }
                });
            }
        }
    }

    public void enableButtons() {
        for (JButton[] button : buttons) {
            for (JButton jButton : button) {
                jButton.setEnabled(true);
            }
        }
    }

    public void customPlayerLabel() {
        playerLabel.setOpaque(true);
        playerLabel.setBackground(orange);
        playerLabel.setForeground(white);

        cpuLabel.setOpaque(true);
        cpuLabel.setBackground(white);
        cpuLabel.setForeground(Color.BLACK);

        playerLabel.repaint();
        cpuLabel.repaint();
    }

    public void customCpuLabel() {
        cpuLabel.setOpaque(true);
        cpuLabel.setBackground(orange);
        cpuLabel.setForeground(white);

        playerLabel.setOpaque(true);
        playerLabel.setBackground(white);
        playerLabel.setForeground(Color.BLACK);

        playerLabel.repaint();
        cpuLabel.repaint();
    }

    public void customWinningButtons(int i, int j) {
        buttons[i][j].setOpaque(true);
        buttons[i][j].setBackground(orange);
        buttons[i][j].setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return white;
            }
        });
        buttons[i][j].repaint();
    }

    public void resetTabContent() {
        playerLabel.setText("");
        cpuLabel.setText("");
    }

    public void clearBoard() {
        for (JButton[] button : buttons) {
            for (JButton jButton : button) {
                jButton.setText("");
                jButton.setEnabled(true);
                jButton.setBackground(white);
                jButton.setUI(new MetalButtonUI() {
                    protected Color getDisabledTextColor() {
                        return Color.BLACK;
                    }
                });
            }
        }
    }

    public void disableTabs() {
        tabbedPane.setEnabledAt(0, false);
        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setEnabledAt(2, false);
    }

    public void enableTabs() {
        tabbedPane.setEnabledAt(0, true);
        tabbedPane.setEnabledAt(1, true);
        tabbedPane.setEnabledAt(2, true);
    }

    public void setInfoTab2(String nickname, String symbol) {
        playerLabelField.setText(nickname);
        cpuLabelField.setText(symbol);
    }

    public void setInfoTab3(String name, String code, String faculty, String school, String semester, ImageIcon icon) {
        devName.setText(name);
        devCode.setText(code);
        devFaculty.setText(faculty);
        devSchool.setText(school);
        devSemester.setText(semester);
        collegeLabel.setIcon(icon);
    }

}
