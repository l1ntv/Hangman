package Input;

import java.util.Scanner;

import Constants.AppConstants;

public class Menu {

    private Menu() {
    }

    public static int fetchChoice() {
        Scanner in = new Scanner(System.in);
        String choice;
        Menu.displayMenu();
        choice = in.next();
        while (!Menu.isItem(choice)) {
            Menu.displayError(choice);
            Menu.displayMenu();
            choice = in.next();
        }
        return Integer.parseInt(choice);
    }

    private static void displayMenu() {
        System.out.println(AppConstants.MENU);
        System.out.print(AppConstants.ENTER_MENU);
    }

    private static void displayError(String choice) {
        if (Menu.isNumber(choice)) {
            System.out.println(AppConstants.INCORRECT_CHOICE);
        } else {
            System.out.println(AppConstants.ENTER_DIGIT);
        }
    }

    private static boolean isItem(String choice) {
        return (choice.equals(AppConstants.START_GAME_CHOICE) || choice.equals(AppConstants.END_GAME_CHOICE));
    }

    private static boolean isNumber(String choice) {
        for (int i = 0; i < choice.length(); i++) {
            if (!Character.isDigit(choice.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}