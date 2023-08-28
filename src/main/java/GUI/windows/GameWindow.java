package GUI.windows;


import GUI.GUI;

import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame {
    private JButton gameButton;
    private JLabel userLabel;
    private JLabel computerResponseLabel;
    private JTextField userInputField;
    private int score;
    private final String computerResponse = "Computer: %s";



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
    private void initGameButton(){
        gameButton = new JButton("Make move");
        gameButton.addActionListener(e -> {
            setVisible(false);
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
