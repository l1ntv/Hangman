package Game;

import Constants.AppConstants;
import Input.Menu;

import java.io.IOException;
import java.util.Locale;

public class MenuStarter {

    private MenuStarter() {
    }

    public static void execute() throws IOException {
        Locale.setDefault(new Locale("ru", "RU"));
        while (true) {
            switch (Menu.fetchChoice()) {
                case (AppConstants.START_GAME_CHOICE):
                    GameCycle.start();
                    break;
                case (AppConstants.END_GAME_CHOICE):
                    System.out.println(AppConstants.END_GAME);
                    return;
            }
        }
    }
}
