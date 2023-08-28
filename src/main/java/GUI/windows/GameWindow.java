package GUI.windows;


import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame {
    private final JButton gameButton;
    private final JLabel userLabel;
    private final JLabel computerResponseLabel;
    private final JTextField userInputField;



    public GameWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        setTitle("Play");
        setLayout(new GridLayout(2,2));
        setLocationRelativeTo(null);

        userInputField = new JTextField(10);

        gameButton = new JButton("Make move");
        gameButton.setSize(30, 30);
//        gameButton.addActionListener(e -> );

        userLabel = new JLabel("Please write city name");

        computerResponseLabel = new JLabel(String.format("Computer: %s", "waiting"));

        add(userInputField);
        add(userLabel);
        add(gameButton);
        add(computerResponseLabel);

        validate();

        setVisible(true);
    }

}
