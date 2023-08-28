package GUI;

import GUI.windows.GameWindow;
import GUI.windows.StartWindow;

public class GUI {
    public static void welcomeWindow(){
        new StartWindow();
    }
    public static void gameWindow(){
        new GameWindow();
    }
}
