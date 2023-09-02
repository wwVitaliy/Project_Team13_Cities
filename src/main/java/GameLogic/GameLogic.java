package GameLogic;

import GUI.GUI;
import GUI.windows.ScoreWindow;
import storage.CitiesDataBase;
import storage.GameWindowData;
import storage.UsedCities;

/**
 * Initialize dataBase, usedCities and gameWindowData.
 * Has methods to updated data.
 * Contains control logic of the game "Cities"
 */
public class GameLogic {

    public static CitiesDataBase dataBase = new CitiesDataBase();
    public static UsedCities usedCities = new UsedCities();
    public static GameWindowData gameWindowData = new GameWindowData();


    /**
     * Gets a name from database which starts from the last letter in given city name.
     *
     * @param name a name to get a last letter from
     * @return A name from database which starts from the last letter in given city name;
     * null - whent the name is not in database
     */
    public static String getComputerAnswer(String name) {

        char lastLetter = name.charAt(name.length() - 1);

        String compAnswer = dataBase.getNextCity(lastLetter).orElse(null);

        moveToUsed(compAnswer);

        return compAnswer;
    }

    /**
     * Checks if a city name is valid.
     * City name is valid when its length is > 1 and it is in dataBase or usedCities.
     *
     * @param name A name to check
     * @return true when the city is in database;
     * false when the city is not in database
     */
    public static boolean isValid(String name) {
        return name.length() > 1
                && (dataBase.containsCity(name.toLowerCase()) || usedCities.isUsed(name.toLowerCase()));
    }

    /**
     * Checks if a response is a match to a previous name.
     * Response matches previous name when its first letter is the same as the last letter of previous name
     *
     * @param response     A city name to check
     * @param previousName A city name to get last letter from
     * @return true when the response matches previous name;
     * false when the response does not match previous name
     */
    public static boolean isCorrectResponse(String response, String previousName) {
        return response.charAt(0) == previousName.charAt(previousName.length() - 1);
    }

    /**
     * Plays a round of a game.
     * Looks for a city name in database which starts from the last letter in given city name.
     * If such name is found returns this name, otherwise - returns null.
     *
     * @param name a name to get a last letter from
     * @return true when the game continues; false when the game is finished
     */
    public static boolean playRound(String name) {

        gameWindowData.incrementScore();

        String nameFromDB = getComputerAnswer(name);

        if (nameFromDB == null) {
            finishGame(ScoreWindow.PLAYER_WIN);
            return false;
        } else {
            gameWindowData.setComputerResponse(nameFromDB);
            return true;
        }

    }

    /**
     * Checks entered text for being a valid city number.
     *
     * @param entry A text to check
     * @return true when entered text is a valid city number;
     * false when entered text is not a valid city number
     */
    public static boolean checkEntry(String entry) {

        if (entry.equals("")) {
            gameWindowData.setUserLabel("You did not enter anything! Please write city name");
            return false;
        } else if (entry.equals("give up")) {
            finishGame(ScoreWindow.COMPUTER_WIN);
            return false;
        } else if (!isValid(entry)) {
            gameWindowData.setUserLabel("I don't now this city. Try one more time");
            return false;
        } else if (!isCorrectResponse(entry, gameWindowData.getComputerResponse())
                && !gameWindowData.getComputerResponse().equals("waiting...")) {
            gameWindowData.setUserLabel("Wrong answer. Try one more time");
            return false;
        } else if (usedCities.isUsed(entry)) {
            gameWindowData.setUserLabel("Was already used. Try one more time");
            return false;

        }

        gameWindowData.setUserLabel("Please write city name");
        moveToUsed(entry);

        return true;
    }

    /**
     * Finishes a game
     *
     * @param winner
     */
    private static void finishGame(String winner) {
        GUI.scoreWindow(gameWindowData.getScore(), winner);
    }

    /**
     * Gets an objects of GameWindowData
     *
     * @return An objects of GameWindowData
     */
    public static GameWindowData getGameWindowData() {
        return gameWindowData;
    }

    /**
     * Moves city name from dataBase to usedCities
     *
     * @param name A name to move
     */
    private static void moveToUsed(String name) {
        dataBase.removeCity(name);
        usedCities.addUsed(name);
    }
}
