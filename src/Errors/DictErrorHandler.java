package Errors;

import Constants.AppConstants;

public class DictErrorHandler {

    private DictErrorHandler() {
    }

    public static void handle(String word) {
        if (!DictErrorHandler.isCorrect(word)) {
            DictErrorHandler.displayMessage();
            return;
        }
    }

    private static boolean isCorrect(String word) {
        return (word != null);
    }

    private static void displayMessage() {
        System.out.println(AppConstants.ERROR_MESSAGE);
    }
}

