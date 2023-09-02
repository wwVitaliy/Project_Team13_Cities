package GUI.windows;

import storage.GameWindowData;
import GameLogic.GameLogic;

import javax.swing.*;
import java.awt.*;

import static storage.GameWindowData.COMPONENTS_DIMENSION;

public class UserPanel extends JPanel {
    private GameWindowData DATA;
    private JButton gameButton;
    private JLabel userLabel;
    private JLabel computerResponseLabel;
    private JTextField userInputField;

    public UserPanel() {
        super(new FlowLayout());
        DATA = GameLogic.getGameWindowData();
        init();
        update();
        setBounds(0, 0, COMPONENTS_DIMENSION.width, COMPONENTS_DIMENSION.height);
    }

    public void update() {
        userLabel.setText(DATA.getUserLabel());
        computerResponseLabel.setText(DATA.getComputerLabel());
    }

    public void init() {
        initUserInputField();
        initUserLabel();
        initGameButton();
        initComputerLabel();
    }

    private void initGameButton() {
        gameButton = new JButton(DATA.getGameButtonText());
        //Додається actionListener до кнопки який виконує якусь логіку
        gameButton.addActionListener(e -> {
            gameButton.setEnabled(false);
            userInputField.setEnabled(false);
            String text = userInputField.getText().toLowerCase();

            if (GameLogic.checkEntry(text)) {
                GameLogic.playRound(text);
            }

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
