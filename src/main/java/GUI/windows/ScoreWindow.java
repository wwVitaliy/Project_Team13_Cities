package GUI.windows;

import GUI.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

//last window
public class ScoreWindow extends JDialog {
    private final int score;
    private final Dimension scoreWindowDimension = new Dimension(400,100);
    private static final String COMPUTER_WIN_FORMAT = "Computer win. Your score: %d";
    private static final String HUMAN_WIN_FORMAT = "Congratulations you win with score: %d";
    public static final String PLAYER_WIN = "player";
    public static final String COMPUTER_WIN = "computer";

    //В конструкторі створюється саме вікно
    // потім валідується і показується людині
    public ScoreWindow(int score, String winner) {
        super(null, "Score", ModalityType.DOCUMENT_MODAL);
        this.score = score;
        config();

        setLayout(new FlowLayout());
        getContentPane().add(createScoreLabel(winner));
        setVisible(true);
    }
    public void config(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - scoreWindowDimension.width/2,
                dimension.height / 2 - scoreWindowDimension.height/2,
                scoreWindowDimension.width,
                scoreWindowDimension.height);

        //city Icon added to title bar
        try {
            File file = new File(GUI.CITY_ICON);
            Image cityIcon = ImageIO.read(file);
            setIconImage(cityIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //creates label and format text like we need in Dialog
    private JLabel createScoreLabel(String winner) {
        if (winner.equals(PLAYER_WIN)) {
            return new JLabel(String.format(HUMAN_WIN_FORMAT, score));
        } else if (winner.equals(COMPUTER_WIN)) {
            return new JLabel(String.format(COMPUTER_WIN_FORMAT, score));
        } else {
            throw new InvalidParameterException("winner should be ScoreWindow.HUMAN_WIN or ScoreWindow.COMPUTER_WIN but was " + winner);
        }
    }
}
