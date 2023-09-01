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
    private static final String COMPUTER_WIN_FORMAT = "Congratulations computer win with score: %d";
    private static final String HUMAN_WIN_FORMAT = "Congratulations you win with score: %d";
    public static final String HUMAN_WIN = "human";
    public static final String COMPUTER_WIN = "computer";

    //В конструкторі створюється саме вікно
    // потім валідується і показується людині
    public ScoreWindow(int score, String whoWin) {
        super(null, "Score", ModalityType.DOCUMENT_MODAL);
        this.score = score;
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

        setLayout(new FlowLayout());
        getContentPane().add(createScoreLabel(whoWin));
        setVisible(true);
    }

    //creates label and format text like we need in Dialog
    private JLabel createScoreLabel(String whoWin) {
        if (whoWin.equals(HUMAN_WIN)) {
            return new JLabel(String.format(HUMAN_WIN_FORMAT, score));
        } else if (whoWin.equals(COMPUTER_WIN)) {
            return new JLabel(String.format(COMPUTER_WIN_FORMAT, score));
        } else {
            throw new InvalidParameterException("whoWin should be ScoreWindow.HUMAN_WIN or ScoreWindow.COMPUTER_WIN but was " + whoWin);
        }
    }
}
