package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class HomeScreen extends JFrame {
    private PlayerInfoScreen playerInfoScreen;
    private HistoryScreen historyScreen;
    private GameScreen gameScreen;
    private PopupPanel popupPanel;
    private ActionListener actionListener;
    private JPanel panel1;
    private String playerSymbol, cpuSymbol;
    private JTextField titleTxtField;
    private JButton playBtn, historyBtn;
    private Color orange = new Color(255, 138, 0);
    private Color white = new Color(255, 255, 255);

    public HomeScreen(ActionListener actionListener) {
        this.actionListener = actionListener;
        this.getContentPane().setPreferredSize(new Dimension(400, 400));
        this.setTitle("Tic Tac Toe Game");
        this.setResizable(false);
        this.setIconImage(new ImageIcon("icons/logo.png").getImage());

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 400, 400);
        panel1.setBackground(white);
        panel1.setBorder(BorderFactory.createLineBorder(orange, 10));

        titleTxtField = new JTextField();
        titleTxtField.setBounds(43, 46, 314, 105);
        titleTxtField.setText("TIC TAC TOE");
        titleTxtField.setHorizontalAlignment(JTextField.CENTER);
        titleTxtField.setFont(new Font("Inter", Font.BOLD, 40));
        titleTxtField.setBackground(white);
        titleTxtField.setForeground(Color.BLACK);
        titleTxtField.setBorder(BorderFactory.createLineBorder(orange, 10));
        titleTxtField.setEditable(false);

        panel1.add(titleTxtField);

        playBtn = new JButton();
        playBtn.setBounds(89, 200, 221, 60);
        playBtn.setText("Play");
        playBtn.setFont(new Font("Inter", Font.BOLD, 32));
        playBtn.setForeground(Color.BLACK);
        playBtn.setBackground(white);
        playBtn.setBorder(BorderFactory.createLineBorder(orange, 10));
        playBtn.setFocusable(false);

        playBtn.addActionListener(actionListener);
        playBtn.setActionCommand("playBtn");

        playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playBtn.setBackground(orange);
                playBtn.setForeground(white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                playBtn.setBackground(white);
                playBtn.setForeground(Color.BLACK);
            }
        });

        panel1.add(playBtn);

        historyBtn = new JButton();
        historyBtn.setBounds(89, 284, 221, 60);
        historyBtn.setText("History");
        historyBtn.setFont(new Font("Inter", Font.BOLD, 32));
        historyBtn.setBackground(white);
        historyBtn.setForeground(Color.BLACK);
        historyBtn.setBorder(BorderFactory.createLineBorder(orange, 10));
        historyBtn.setFocusable(false);

        historyBtn.addActionListener(actionListener);
        historyBtn.setActionCommand("historyBtn");

        historyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyBtn.setBackground(orange);
                historyBtn.setForeground(white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyBtn.setBackground(white);
                historyBtn.setForeground(Color.BLACK);
            }
        });

        panel1.add(historyBtn);

        this.add(panel1);

        this.add(playerInfoScreen = new PlayerInfoScreen(actionListener));
        this.add(gameScreen = new GameScreen(actionListener));

        this.pack();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void changePanelInfo() {
        panel1.setVisible(false);
        playerInfoScreen.setVisible(true);
    }

    public void tableRowInfo(ArrayList<String> data) {
        this.add(historyScreen = new HistoryScreen(actionListener, data));
    }

    public void changeHistoryPanel() {
        panel1.setVisible(false);
        historyScreen.setVisible(true);
    }

    public void goBack() {
        historyScreen.setVisible(false);
        panel1.setVisible(true);
    }

    public void changePanelMain() {
        panel1.setVisible(true);
        playerInfoScreen.setVisible(false);
    }

    public void changePanelTabs() {
        if (!playerInfoScreen.getNickname().equals("")) {
            if (playerInfoScreen.getSymbol().equals("X")) {
                playerSymbol = "X";
                cpuSymbol = "O";
            } else {
                playerSymbol = "O";
                cpuSymbol = "X";
            }

            playerInfoScreen.setVisible(false);
            gameScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Nickname, please try again!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPlayerLabel() {
        gameScreen.setPlayerLabel(playerInfoScreen.getSymbol() + " - " + playerInfoScreen.getNickname());
    }

    public void setCpuLabel() {
        if (playerInfoScreen.getSymbol().equals("X")) {
            gameScreen.setCpuLabel("O - CPU");
        } else {
            gameScreen.setCpuLabel("X - CPU");
        }
    }

    public void setPlayerTextButton(int i, int j) {
        gameScreen.disableButtons();
        gameScreen.setButton(i, j, playerInfoScreen.getSymbol());
    }

    public void setCpuTextButton(int i, int j) {
        gameScreen.setButton(i, j, cpuSymbol);
        gameScreen.enableButtons();
    }

    public void disableCpuSelection(int i, int j) {
        gameScreen.disableCpuButton(i, j);
    }

    public String getCpuFigure() {
        return cpuSymbol;
    }

    public String getPlayerFigure() {
        return playerSymbol;
    }

    public void disableIfWin() {
        gameScreen.disableButtons();
    }

    public void playerTurnLabel() {
        gameScreen.customPlayerLabel();
    }

    public void cpuTurnLabel() {
        gameScreen.customCpuLabel();
    }

    public void paintWinningButtons(int i, int j, int k, int l, int m, int n) {
        gameScreen.customWinningButtons(i, j);
        gameScreen.customWinningButtons(k, l);
        gameScreen.customWinningButtons(m, n);
    }

    public String getUserNickname() {
        return playerInfoScreen.getNickname();
    }

    public void clearInfo() {
        gameScreen.resetTabContent();
        gameScreen.clearBoard();
        playerInfoScreen.resetPlayerInfo();
    }

    public void goToMainMenu() {
        clearInfo();
        gameScreen.setVisible(false);
        popupPanel.setVisible(false);
        panel1.setVisible(true);
        gameScreen.enableTabs();
    }

    public void showPopup() {
        popupPanel.setVisible(true);
        gameScreen.disableTabs();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 400, 400);
        layeredPane.add(panel1, valueOf(0), 0);
        layeredPane.add(playerInfoScreen, valueOf(1), 0);
        layeredPane.add(gameScreen, valueOf(2), 0);
        layeredPane.add(popupPanel, valueOf(3), 0);

        setContentPane(layeredPane);
    }

    public void infoTab2() {
        gameScreen.setInfoTab2(playerInfoScreen.getNickname(), playerInfoScreen.getSymbol());
    }

    public void customPopup(Color bgColor, Color brdColor, ImageIcon icon, String message) {
        this.add(popupPanel = new PopupPanel(actionListener, bgColor, brdColor, icon, message));
        showPopup();
    }

    public void hidePopup() {
        popupPanel.setVisible(false);
        gameScreen.enableTabs();
    }

    public void infoTab3(String name, String code, String faculty, String school, String semester, ImageIcon icon) {
        gameScreen.setInfoTab3(name, code, faculty, school, semester, icon);
    }

}

