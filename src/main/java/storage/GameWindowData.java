package storage;


import java.awt.*;

public class GameWindowData {
    //constants
    public static final Dimension WINDOW_DIMENSION = new Dimension(400, 500);
    public static final Dimension COMPONENTS_DIMENSION = new Dimension(300, 80);
    private static final String COMPUTER_RESPONSE_FORMAT = "Computer: %s";
    private static final String GAME_BUTTON_TEXT = "Play";
    private static final String DEFAULT_INPUT_LABEL = "Please write city name";
    private static final String DEFAULT_COMPUTER_RESPONSE = "waiting...";


    //fields

    private int score;
    private String userLabel;
    private String computerLabel;
    private String gameButtonText;
    private String computerResponse;


    public GameWindowData() {
        this.gameButtonText = GAME_BUTTON_TEXT;
        this.userLabel = DEFAULT_INPUT_LABEL;
        this.computerResponse = DEFAULT_COMPUTER_RESPONSE;
        this.computerLabel = String.format(COMPUTER_RESPONSE_FORMAT, computerResponse);
        this.score = 0;
    }

    public void setComputerLabelText(String cityName) {
        computerLabel = String.format(COMPUTER_RESPONSE_FORMAT, cityName);
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
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

    public String getGameButtonText() {
        return GAME_BUTTON_TEXT;
    }

    public void setGameButtonText(String gameButtonText) {
        this.gameButtonText = gameButtonText;
    }

    public String getComputerResponse() {
        return computerResponse;
    }

    public void setComputerResponse(String computerResponse) {
        this.computerResponse = computerResponse;
        setComputerLabelText(computerResponse);
    }
}
