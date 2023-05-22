package model;

public class Player {
    private String nickname;
    private String symbol;

    public Player() {}

    public Player(String nickname, String symbol) {
        this.nickname = nickname;
        this.symbol = symbol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
