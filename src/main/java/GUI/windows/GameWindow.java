package GUI.windows;

import GUI.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


//GameWindow це відображення ігрового вікна
public class GameWindow extends JFrame {

    //Поля для кнопок і тексту і поле score для храніння рахунку
    private JButton gameButton;
    private JLabel userLabel;
    private JLabel computerResponseLabel;
    private JTextField userInputField;
    private int score;
    private static final String computerResponse = "Computer: %s";
    public static final Dimension windowDimension = new Dimension(400, 500);
    public static final Dimension componentsDimension = new Dimension(180, 150);

    //В конструкторі ініціалізується всі поля і валідується і показується людині
    public GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - windowDimension.width / 2,
                dimension.height / 2 - windowDimension.height / 2,
                windowDimension.width,
                windowDimension.height);
        setTitle("Cities");
        setLayout(null);
        setLocationRelativeTo(null);

        //city Icon added to title bar
        try {
            File file = new File("./src/main/resources/cityIcon.jpg");
            Image cityIcon = ImageIO.read(file);
            setIconImage(cityIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        initGameButton();
        initComputerLabel();
        initUserLabel();
        initUserInputField();

        validate();

        setVisible(true);
    }

    //initialisation gameButton and adds gameButton to GameWindow
    private void initGameButton() {
        gameButton = new JButton("Make move");
        //Додається actionListener до кнопки який виконує якусь логіку
        gameButton.addActionListener(e -> {
            gameButton.setEnabled(false);
            userInputField.setEnabled(false);
            String text = userInputField.getText();
            if (text.equals("surrender")) {
                GUI.scoreWindow();
            } else {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                //use GameLogic to take nextCity
            }

            gameButton.setEnabled(true);
            userInputField.setEnabled(true);
        });
        gameButton.setBounds(25, 220, componentsDimension.width, componentsDimension.height);
        add(gameButton);
    }

    //initialisation userLabel and adds userLabel to GameWindow
    private void initUserLabel() {
        userLabel = new JLabel("Please write city name");
        userLabel.setBounds(220, 25,  componentsDimension.width, componentsDimension.height);
        add(userLabel);
    }

    //initialisation userInputField and adds userInputField to GameWindow
    private void initUserInputField() {
        userInputField = new JTextField(10);
        userInputField.setBounds(25, 50,  componentsDimension.width, componentsDimension.height);
        add(userInputField);
    }

    //initialisation computerResponseLabel and adds computerResponseLabel to GameWindow
    private void initComputerLabel() {
        computerResponseLabel = new JLabel(String.format(computerResponse, "waiting"));
        computerResponseLabel.setBounds(220, 220,  componentsDimension.width, componentsDimension.height);
        add(computerResponseLabel);
    }
}