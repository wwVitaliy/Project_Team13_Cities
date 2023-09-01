package storage;

import java.awt.*;

public class GameWindowData {
    //constants
    public static final Dimension windowDimension = new Dimension(400, 500);
    public static final Dimension componentsDimension = new Dimension(300, 80);
    private static final String computerResponseFormat = "      Computer: %s";

    //fields

    private int score;
    private String userLabel;
    private String computerLabel;
    private String gameButton;

    public GameWindowData(){
        this.gameButton = "    Play    ";
        this.userLabel = "Please write city name";
        this.computerLabel = String.format(computerResponseFormat, "waiting");
        this.score = 0;
    }

    public void setComputerLabelText(String cityName){
        computerLabel = String.format(computerResponseFormat, cityName);
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(){
        score++;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getComputerLabel() {
        return computerLabel;
    }

    public void setComputerLabel(String computerLabel) {
        this.computerLabel = computerLabel;
    }

    public String getGameButton() {
        return gameButton;
    }

    public void setGameButton(String gameButton) {
        this.gameButton = gameButton;
    }
}
