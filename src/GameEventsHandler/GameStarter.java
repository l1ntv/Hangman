package GameEventsHandler;

import InputHandler.MenuInputHandler;

import java.io.IOException;
import java.util.Locale;

public class GameStarter {
    private final static String END_GAME_CONST = "Игра завершена.";
    private final static int START_GAME_CHOICE_MENU = 1;
    private final static int END_GAME_CHOICE_MENU = 2;

    public static void start() throws IOException {
        Locale.setDefault(new Locale("ru", "RU"));
        while (true) {
            switch (MenuInputHandler.inputMenuChoice()) {
                case (GameStarter.START_GAME_CHOICE_MENU):
                    GameCycleHandler.game();
                    break;
                case (GameStarter.END_GAME_CHOICE_MENU):
                    System.out.println(GameStarter.END_GAME_CONST);
                    return;
            }
        }
    }
}
