package Validator;

public class MenuInputValidator {
    private final static int START_GAME_CHOICE_MENU = 1;
    private final static int END_GAME_CHOICE_MENU = 2;
    public static boolean isMenuChoiceCorrect(int gameChoice) {
        return (gameChoice == MenuInputValidator.START_GAME_CHOICE_MENU || gameChoice == MenuInputValidator.END_GAME_CHOICE_MENU);
    }
}
