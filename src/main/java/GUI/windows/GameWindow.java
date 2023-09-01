package GUI.windows;

import GUI.GUI;
import storage.GameWindowData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static storage.GameWindowData.componentsDimension;
import static storage.GameWindowData.windowDimension;


//GameWindow це відображення ігрового вікна
public class GameWindow extends JFrame {

    //Поля для кнопок і тексту і поле score для храніння рахунку

    private final UserPanel userPanel;

    //В конструкторі ініціалізується всі поля і валідується і показується людині
    public GameWindow() {
        config();
        addIcon();

        userPanel = new UserPanel();
        add(userPanel);

        validate();

        setVisible(true);
    }

    private void config(){
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
    }
    private void addIcon(){
        try {
            File file = new File(GUI.CITY_ICON);
            Image cityIcon = ImageIO.read(file);
            setIconImage(cityIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
