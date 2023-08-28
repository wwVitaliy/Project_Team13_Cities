package GUI.windows;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    private final JButton startButton;
    private final JLabel welcomeLabel;

    public JButton getStartButton() {
        return startButton;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    public StartWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 200, dimension.height / 2 - 50, 400, 100);
        setTitle("Welcome");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);


        startButton = new JButton("Start");
        startButton.setSize(30, 30);
        startButton.addActionListener(e -> {
            setVisible(false);
            GUI.gameWindow();
        });

        welcomeLabel = new JLabel("Welcome to Cities Game! Press Start to begin.");

        add(welcomeLabel);
        add(startButton);


        validate();

        setVisible(true);
    }
}
