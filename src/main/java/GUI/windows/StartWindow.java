package GUI.windows;

import GUI.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//Клас StartWindow є відображенням вітального вікна
public class StartWindow extends JFrame {
    //Це поля для кнопки і текстового рядка
    private final JButton startButton;
    private final JLabel welcomeLabel;

    //В конструкторі створюється саме вікно і
    //додаються кнопка з текстом
    // потім валідується і показується людині
    public StartWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 200, dimension.height / 2 - 50, 400, 100);
        setTitle("Welcome");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        //city Icon added to title bar
        try {
            File file = new File(GUI.CITY_ICON);
            Image cityIcon = ImageIO.read(file);
            setIconImage(cityIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        startButton = new JButton("Start");
        startButton.setSize(30, 30);
        //Додається actionListener до кнопки
        // при натисканні вікно зникає і
        // викликається метод  GUI.gameWindow який має створювати ігрове вікно
        startButton.addActionListener(e -> {
            dispose();
            GUI.gameWindow();
        });

        welcomeLabel = new JLabel("Welcome to Cities Game! Press Start to begin.");

        add(welcomeLabel);
        add(startButton);

        validate();

        setVisible(true);
    }
}
