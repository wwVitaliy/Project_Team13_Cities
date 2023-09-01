package storage;

public class GameWindowData {
    public String inputFieldLabel;
    public String computerResponse;
    public int playersScore;

    public GameWindowData() {
        this.inputFieldLabel = "Your turn! Enter city name here.";
        this.computerResponse = "";
        this.playersScore = 0;
    }

    public String getInputFieldText() {
        return inputFieldLabel;
    }

    public void setInputFieldText(String inputFieldText) {
        this.inputFieldLabel = inputFieldText;
    }

    public String getComputerResponse() {
        return computerResponse;
    }

    public void setComputerResponse(String computerResponse) {
        this.computerResponse = computerResponse;
    }

    public int getPlayersScore() {
        return playersScore;
    }

//    public void setPlayersScore(int playersScore) {
//        this.playersScore = playersScore;
//    }

    /**
     * Increments player's score
     */
    public void increasePlayersScore() {
        this.playersScore++;
    }
}
