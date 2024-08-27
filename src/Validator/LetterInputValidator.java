package Validator;

import java.util.regex.Pattern;

public class LetterInputValidator {
    public static boolean isEnteredCharacterCorrect(char letter) {
        String regex = "[А-Яа-яЁё]";
        return Pattern.matches(regex, String.valueOf(letter));
    }
}
