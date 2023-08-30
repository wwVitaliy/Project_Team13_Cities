package GUI.windows;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;


//GameWindow це відображення ігрового вікна
public class GameWindow extends JFrame {

    //Поля для кнопок і тексту і поле score для храніння рахунку
    private JButton gameButton;
    private JLabel userLabel;
    private JLabel computerResponseLabel;
    private JTextField userInputField;
    private int score;
    private final String computerResponse = "Computer: %s";


        //В конструкторі ініціалізується всі поля і валідується і показується людині
    public GameWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        setTitle("Cities");
        setLayout(null);
        setLocationRelativeTo(null);

        initGameButton();
        initComputerLabel();
        initUserLabel();
        initUserInputField();

        validate();

        setVisible(true);
    }

    //Всі методи які починаються з init для того щоб зменшити кількість коду в конструкторі
    private void initGameButton(){
        gameButton = new JButton("Make move");
        //Додається actionListener до кнопки який виконує якусь логіку
        gameButton.addActionListener(e -> {
            gameButton.setEnabled(false);
            userInputField.setEnabled(false);
            String text = userInputField.getText();
            if (text.equals("surrender")){
                GUI.scoreWindow(score);
            }
            //use GameLogic to take nextCity
        });
        gameButton.setBounds(25,220,180,150);
        add(gameButton);
    }
    private void initUserLabel(){
        userLabel = new JLabel("Please write city name");
        userLabel.setBounds(220,25,180,150);
        add(userLabel);
    }
    private void initUserInputField(){
        userInputField = new JTextField(10);
        userInputField.setBounds(25,50,180,150);
        add(userInputField);
    }
    private void initComputerLabel(){
        computerResponseLabel = new JLabel(String.format(computerResponse, "waiting"));
        computerResponseLabel.setBounds(220,220,180,150);
        add(computerResponseLabel);
    }

}
