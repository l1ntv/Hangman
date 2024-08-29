package Input;

import java.util.Scanner;
import java.util.regex.Pattern;

import Constants.AppConstants;

public class Game {

    private Game() {
    }

    public static String input() {
        Scanner in = new Scanner(System.in);
        String letter = AppConstants.EMPTY_STRING;
        while (!Game.isLengthOne(letter) || !Game.isCorrect(letter.charAt(AppConstants.FIRST_INDEX))) {
            System.out.print(AppConstants.ENTER_LETTER);
            letter = in.next();
            if (!Game.isLengthOne(letter)) {
                System.out.println(AppConstants.ENTER_ONE_LETTER);
            } else {
                if (!Game.isCorrect(letter.charAt(AppConstants.FIRST_INDEX))) {
                    System.out.println(AppConstants.ENTER_CORRECT_LETTER);
                    System.out.print(AppConstants.ENTER_LETTER);
                } else {
                    return letter.toLowerCase();
                }
            }
        }
        return letter.toLowerCase();
    }

    private static boolean isLengthOne(String string) {
        return (string.length() == 1);
    }

    private static boolean isCorrect(char letter) {
        return (Pattern.matches(AppConstants.REGEX_RUSSIAN_LETTERS, String.valueOf(letter)));
    }
}