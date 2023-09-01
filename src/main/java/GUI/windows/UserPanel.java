package GUI.windows;

import storage.GameWindowData;

import javax.swing.*;
import java.awt.*;

import static storage.GameWindowData.componentsDimension;

public class UserPanel extends JPanel {
    private GameWindowData DATA;
    private JButton gameButton;
    private JLabel userLabel;
    private JLabel computerResponseLabel;
    private JTextField userInputField;

    public UserPanel() {
        super(new FlowLayout());
        DATA = new GameWindowData(); //DATA = GameLogic.getGameWindowData();
        init();
        update();
        setBounds(0, 0, componentsDimension.width, componentsDimension.height);
    }

    public void update(){
        userLabel.setText(DATA.getUserLabel());
        gameButton.setText(DATA.getGameButton());
        computerResponseLabel.setText(DATA.getComputerLabel());
    }

    public void init() {
        initUserInputField();
        initUserLabel();
        initGameButton();
        initComputerLabel();
    }

    private void initGameButton() {
        gameButton = new JButton(DATA.getGameButton());
        //Додається actionListener до кнопки який виконує якусь логіку
        gameButton.addActionListener(e -> {
            gameButton.setEnabled(false);
            userInputField.setEnabled(false);
            String text = userInputField.getText();

            //GameLogic.checkEntry(text);
            //GameLogic.playRound(text);

            update();
            gameButton.setEnabled(true);
            userInputField.setEnabled(true);
        });
        add(gameButton);
    }

    //initialisation userLabel and adds userLabel to GameWindow
    private void initUserLabel() {
        userLabel = new JLabel(DATA.getUserLabel());
        add(userLabel);
    }

    //initialisation userInputField and adds userInputField to GameWindow
    private void initUserInputField() {
        userInputField = new JTextField(10);
        add(userInputField);
    }

    //initialisation computerResponseLabel and adds computerResponseLabel to GameWindow
    private void initComputerLabel() {
        computerResponseLabel = new JLabel(DATA.getComputerLabel());
        add(computerResponseLabel);
    }
}
