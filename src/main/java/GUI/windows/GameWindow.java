package GUI.windows;

import GUI.GUI;
import storage.CitiesDataBase;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//GameWindow це відображення ігрового вікна
public class GameWindow extends JFrame {

    //Поля для кнопок і тексту і поле score для храніння рахунку
    private final UserPanel userPanel;
    private final JList<Object> jlistUsedCities;
    private final List<String> usedCities;
    private int score;
    private static final String userTipFormat = "Your turn the letter is '%s'";
    private static final String computerResponseFormat = "      Computer: %s";
    public static final Dimension windowDimension = new Dimension(400, 500);
    public static final Dimension componentsDimension = new Dimension(300, 80);

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
        setBackground(Color.WHITE);

        usedCities = new ArrayList<>();
        usedCities.add("Used Cities: ");
        jlistUsedCities = new JList<>(usedCities.toArray());
        jlistUsedCities.setBounds(0, 80, 240, 420);
        userPanel = new UserPanel();
        add(userPanel);
        add(jlistUsedCities);

        //city Icon added to title bar
        try {
            File file = new File(GUI.CITY_ICON);
            Image cityIcon = ImageIO.read(file);
            setIconImage(cityIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        validate();

        setVisible(true);
    }

    class UserPanel extends JPanel {
        private final CitiesDataBase citiesDataBase = new CitiesDataBase();
        private String lastLetter = "";
        private JButton gameButton;
        private JLabel userLabel;
        private JLabel computerResponseLabel;
        private JTextField userInputField;

        private UserPanel() {
            super(new FlowLayout());
            init();
            setBounds(0, 0, componentsDimension.width, componentsDimension.height);
            setEnabled(true);
        }

        public void init() {
            initUserInputField();
            initUserLabel();
            initGameButton();
            initComputerLabel();
        }

        private void initGameButton() {
            gameButton = new JButton("    Play    ");
            //Додається actionListener до кнопки який виконує якусь логіку
            gameButton.addActionListener(e -> {
                gameButton.setEnabled(false);
                userInputField.setEnabled(false);
                String text = userInputField.getText();
                if (text.equals("surrender")) {
                    dispose();
                    GUI.scoreWindow(score, ScoreWindow.COMPUTER_WIN);
                } else if (!text.startsWith(lastLetter)) {
                    userLabel.setText("Write correct value letter is '" + lastLetter + "'");
                } else if (usedCities.contains(text)) {
                    computerResponseLabel.setText("Don't repeat cities please");
                } else if (!citiesDataBase.containsCity(text)) {
                    computerResponseLabel.setText("We don't now this city");
                } else {
                    showNextCity(text);
                }

                gameButton.setEnabled(true);
                userInputField.setEnabled(true);
            });
            add(gameButton);
        }

        private void showNextCity(String text) {
            String nextCity = citiesDataBase.nextCity(text);
            if (nextCity == null) {
                dispose();
                GUI.scoreWindow(score, ScoreWindow.HUMAN_WIN);
                return;
            }
            lastLetter = nextCity.substring(nextCity.length() - 1);
            userLabel.setText(String.format(userTipFormat, lastLetter));
            computerResponseLabel.setText(String.format(computerResponseFormat, nextCity));
            usedCities.add(nextCity);
            usedCities.add(text);
            jlistUsedCities.setListData(usedCities.toArray());
            score++;
        }

        //initialisation userLabel and adds userLabel to GameWindow
        private void initUserLabel() {
            userLabel = new JLabel("Please write city name");
            add(userLabel);
        }

        //initialisation userInputField and adds userInputField to GameWindow
        private void initUserInputField() {
            userInputField = new JTextField(10);
            add(userInputField);
        }

        //initialisation computerResponseLabel and adds computerResponseLabel to GameWindow
        private void initComputerLabel() {
            computerResponseLabel = new JLabel(String.format(computerResponseFormat, "waiting"));
            add(computerResponseLabel);
        }
    }
}
