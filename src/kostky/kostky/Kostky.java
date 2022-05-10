package kostky.kostky;

import kostky.kostky.view.MainMenu;

public class Kostky {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        mainMenu.setDefaultCloseOperation(mainMenu.EXIT_ON_CLOSE);
    }
}
