package GUI.windows;

import storage.GameWindowData;
import GameLogic.GameLogic;

import javax.swing.*;

import static storage.GameWindowData.*;

public class UserPanel extends JPanel {
    private GameWindowData DATA;
    private JButton gameButton;
    private JLabel userLabel;
    private JLabel computerResponseLabel;
    private JTextField userInputField;

    public UserPanel() {
        super(null);
        DATA = GameLogic.getGameWindowData();
        init();
        update();
        setBounds(0, 0, PANEL_DIMENSION.width, PANEL_DIMENSION.height);
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
        gameButton.setBounds(5,45,COMPONENT_DIMENSION.width,COMPONENT_DIMENSION.height);
        //Додається actionListener до кнопки який виконує якусь логіку
        gameButton.addActionListener(e -> {
            gameButton.setEnabled(false);
            userInputField.setEnabled(false);
            String text = userInputField.getText().toLowerCase();

            if (GameLogic.checkEntry(text)) {
                GameLogic.playRound(text);
                userInputField.setText("");
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
        userLabel.setBounds(140,10,LABEL_DIMENSION.width,LABEL_DIMENSION.height);
        add(userLabel);
    }
    //initialisation computerResponseLabel and adds computerResponseLabel to GameWindow
    private void initComputerLabel() {
        computerResponseLabel = new JLabel(DATA.getComputerLabel());
        computerResponseLabel.setBounds(140,45,LABEL_DIMENSION.width,LABEL_DIMENSION.height);
        add(computerResponseLabel);
    }

    //initialisation userInputField and adds userInputField to GameWindow
    private void initUserInputField() {
        userInputField = new JTextField(10);
        userInputField.setBounds(5,10,COMPONENT_DIMENSION.width,COMPONENT_DIMENSION.height);
        add(userInputField);
    }
}
