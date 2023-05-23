package presenter;

import model.Player;
import tools.ReadTxtFile;
import tools.WriteTxtFile;
import view.HomeScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;


public class Presenter implements ActionListener {
    private HomeScreen homeScreen;
    private String[][] board;
    private ArrayList<String> appData;
    private Random random;
    private String gameResult;
    private Player player;
    private WriteTxtFile writeTxtFile;
    private ReadTxtFile readTxtFile;

    public Presenter() throws IOException {
        homeScreen = new HomeScreen(this);
        board = new String[][]{{"", "", ""}, {"", "", ""}, {"", "", ""}};
        player = new Player();
    }

    private boolean isGameFinished() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2]) && !board[row][0].equals("")) {
                homeScreen.disableIfWin();
                homeScreen.paintWinningButtons(row, 0, row, 1, row, 2);
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(board[1][col]) && board[1][col].equals(board[2][col]) && !board[0][col].equals("")) {
                homeScreen.disableIfWin();
                homeScreen.paintWinningButtons(0, col, 1, col, 2, col);
                return true;
            }
        }

        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
            homeScreen.disableIfWin();
            homeScreen.paintWinningButtons(0, 0, 1, 1, 2, 2);
            return true;
        }

        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("")) {
            homeScreen.disableIfWin();
            homeScreen.paintWinningButtons(0, 2, 1, 1, 2, 0);
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].equals(""))
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "playBtn":
                homeScreen.changePanelInfo();
                break;
            case "historyBtn":
                setTableContent();
                homeScreen.changeHistoryPanel();
                break;
            case "histMenuBtn":
                homeScreen.goBack();
                break;
            case "backBtn":
                homeScreen.changePanelMain();
                break;
            case "startBtn":
                homeScreen.changePanelTabs();
                homeScreen.setPlayerLabel();
                homeScreen.setCpuLabel();
                homeScreen.infoTab2();
                homeScreen.infoTab3(Constants.DEV_NAME, Constants.DEV_CODE, Constants.DEV_FACULTY, Constants.DEV_SCHOOL, Constants.DEV_COLLEGE_YEAR, Constants.COLLEGE_ICON);
                break;
            case "menuBtn":
                clearStringBoard();
                homeScreen.goToMainMenu();
                homeScreen.playerTurnLabel();
                break;
            case "okBtn":
                homeScreen.hidePopup();
                break;

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (command.equals("button" + i + j)) {
                    homeScreen.setPlayerTextButton(i, j);
                    board[i][j] = homeScreen.getPlayerFigure();

                    if (!isGameFinished()) {
                        homeScreen.cpuTurnLabel();
                        if (!isBoardFull()) {
                            Timer timer = new Timer(900, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    cpu();

                                    if (isGameFinished()) {
                                        gameResult = "Lost";

                                        try {
                                            writeMatchData();
                                        } catch (IOException ex) {
                                            throw new RuntimeException(ex);
                                        }

                                        Timer timer2 = new Timer(1000, new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                homeScreen.customPopup(Constants.LOSE_BG, Constants.LOSE_BRD, Constants.CPU_ICON, Constants.LOSE_MESSAGE);
                                            }
                                        });

                                        timer2.setRepeats(false);
                                        timer2.start();
                                    } else {
                                        homeScreen.playerTurnLabel();
                                    }
                                }
                            });

                            timer.setRepeats(false);
                            timer.start();

                            if (isGameFinished()) {
                                gameResult = "Lost";

                                try {
                                    writeMatchData();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                                Timer timer3 = new Timer(1000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        homeScreen.customPopup(Constants.LOSE_BG, Constants.LOSE_BRD, Constants.CPU_ICON, Constants.LOSE_MESSAGE);
                                    }
                                });

                                timer3.setRepeats(false);
                                timer3.start();
                            }
                        } else {
                            gameResult = "Draw";

                            try {
                                writeMatchData();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                            Timer timer4 = new Timer(1000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    homeScreen.customPopup(Constants.DRAW_BG, Constants.DRAW_BRD, Constants.SERIOUS_ICON, Constants.DRAW_MESSAGE);
                                }
                            });

                            timer4.setRepeats(false);
                            timer4.start();
                        }
                    } else {
                        gameResult = "Won";

                        try {
                            writeMatchData();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                        Timer timer5 = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                homeScreen.customPopup(Constants.WIN_BG, Constants.WIN_BRD, Constants.TROPHY_ICON, Constants.WIN_MESSAGE);
                            }
                        });

                        timer5.setRepeats(false);
                        timer5.start();
                    }
                }
            }
        }
    }

    private boolean makeCpuWin(String figure) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals(board[i][1]) && board[i][0].equals(figure)) ||
                    (board[i][0].equals(board[i][2]) && board[i][2].equals(figure)) ||
                    (board[i][1].equals(board[i][2]) && board[i][1].equals(figure))) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("")) {
                        board[i][j] = homeScreen.getCpuFigure();
                        homeScreen.setCpuTextButton(i, j);
                        homeScreen.disableCpuSelection(i, j);
                        return true;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if ((board[0][i].equals(board[1][i]) && board[0][i].equals(figure)) ||
                    (board[0][i].equals(board[2][i]) && board[2][i].equals(figure)) ||
                    (board[1][i].equals(board[2][i]) && board[1][i].equals(figure))) {
                for (int j = 0; j < 3; j++) {
                    if (board[j][i].equals("")) {
                        board[j][i] = homeScreen.getCpuFigure();
                        homeScreen.setCpuTextButton(j, i);
                        homeScreen.disableCpuSelection(j, i);
                        return true;
                    }
                }
            }
        }

        if ((board[0][0].equals(board[1][1]) && board[0][0].equals(figure)) ||
                (board[0][0].equals(board[2][2]) && board[2][2].equals(figure)) ||
                (board[1][1].equals(board[2][2]) && board[1][1].equals(figure))) {
            for (int i = 0; i < 3; i++) {
                if (board[i][i].equals("")) {
                    board[i][i] = homeScreen.getCpuFigure();
                    homeScreen.setCpuTextButton(i, i);
                    homeScreen.disableCpuSelection(i, i);
                    return true;
                }
            }
        }

        if ((board[0][2].equals(board[1][1]) && board[0][2].equals(figure)) ||
                (board[0][2].equals(board[2][0]) && board[0][2].equals(figure)) ||
                (board[1][1].equals(board[2][0]) && board[1][1].equals(figure))) {
            for (int i = 0; i < 3; i++) {
                if (board[i][2 - i].equals("")) {
                    board[i][2 - i] = homeScreen.getCpuFigure();
                    homeScreen.setCpuTextButton(i, 2 - i);
                    homeScreen.disableCpuSelection(i, 2 - i);
                    return true;
                }
            }
        }
        return false;
    }

    private void cpu() {
        random = new Random();
        int row, col;

        if (!makeCpuWin(homeScreen.getCpuFigure())) {
            if (!makeCpuWin(homeScreen.getPlayerFigure())) {
                do {
                    row = random.nextInt(3);
                    col = random.nextInt(3);
                } while (!board[row][col].equals(""));

                board[row][col] = homeScreen.getCpuFigure();
                homeScreen.setCpuTextButton(row, col);
                homeScreen.disableCpuSelection(row, col);
            }
        }
    }

    private void clearStringBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }

    private String gameFinishedTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    }

    public void asignPlayerData() {
        player.setNickname(homeScreen.getUserNickname());
        player.setSymbol(homeScreen.getPlayerFigure());
    }

    private String matchData() {
        asignPlayerData();
        return player.getNickname() + ";" + player.getSymbol() + ";" + gameResult + ";" + gameFinishedTime();
    }

    private void writeMatchData() throws IOException {
        writeTxtFile.write(Constants.PATH, matchData());
    }

    public void setTableContent() {
        homeScreen.tableRowInfo(readTxtFile.read(Constants.PATH));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Presenter();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
