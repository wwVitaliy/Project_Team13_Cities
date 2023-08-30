package GUI;

import GUI.windows.GameWindow;
import GUI.windows.StartWindow;

//GUI це клас який просто має створювати об'єкти класів з пакету windows
public class GUI {
    public static void startWindow(){
        new StartWindow();
    }
    public static void gameWindow(){
        new GameWindow();
    }
    public static void scoreWindow(){

    }
}
