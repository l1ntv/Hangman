package InputHandler;

import Validator.LetterInputValidator;

import java.util.Scanner;

public class LetterInputHandler {
    private final static String ENTER_LETTER_CONST = "Ввод буквы: ";
    private final static String ENTER_CORRECT_LETTER_CONST = "Ошибка: введите русскую букву.";

    public static char inputLetterByUser() {
        Scanner in = new Scanner(System.in);
        char enteredLetter;
        System.out.print(LetterInputHandler.ENTER_LETTER_CONST);
        enteredLetter = Character.toLowerCase(in.next().charAt(0));
        while (!LetterInputValidator.isEnteredCharacterCorrect(enteredLetter)) {
            System.out.println(LetterInputHandler.ENTER_CORRECT_LETTER_CONST);
            System.out.print(LetterInputHandler.ENTER_LETTER_CONST);
            enteredLetter = Character.toLowerCase(in.next().charAt(0));
        }
        return enteredLetter;
    }
}
