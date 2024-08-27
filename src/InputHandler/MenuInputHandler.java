package InputHandler;

import Validator.MenuInputValidator;

import java.util.Scanner;

public class MenuInputHandler {
    private final static String MENU_CONST = "Меню:\n1. Начать игру.\n2. Выйти из игры.";
    private final static String ENTER_MENU_CONST = "Ввод: ";

    public static int inputMenuChoice() {
        Scanner in = new Scanner(System.in);
        int menuChoice = 0;
        System.out.println(MenuInputHandler.MENU_CONST);
        while (!MenuInputValidator.isMenuChoiceCorrect(menuChoice)) {
            System.out.print(MenuInputHandler.ENTER_MENU_CONST);
            menuChoice = in.nextInt();
        }
        return menuChoice;
    }
}
