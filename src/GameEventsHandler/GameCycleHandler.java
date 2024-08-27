package GameEventsHandler;

import ErrorHandler.DictErrorHandler;
import Graphics.HangingRackStringGenerator;
import InputHandler.LetterInputHandler;
import WordHandler.WordGenerator;
import WordHandler.WordMaskGenerator;
import WordHandler.WordMaskUpdater;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GameCycleHandler {
    private final static String ALREADY_ENTERED_LETTER_CONST = "Вы уже вводили эту букву.";
    private final static String INCORRECT_LETTER_CONST = "Неправильно!";

    public static void game() throws IOException {
        Set<Character> usedLettersByUser = new HashSet<>();
        char enteredLetter;
        int userWrongs = 0;
        String gameWord = WordGenerator.findRandomWord().toLowerCase();
        DictErrorHandler.dictErrorHandler(gameWord);
        String userWord = WordMaskGenerator.createWordMask(gameWord);
        System.out.println(userWord);
        while (GameCycleHandler.isGameContinues(userWord, gameWord, userWrongs)) {
            enteredLetter = LetterInputHandler.inputLetterByUser();
            if (!usedLettersByUser.contains(enteredLetter)) {
                if (GameCycleHandler.isLetterConsistInWord(gameWord, enteredLetter)) {
                    userWord = WordMaskUpdater.updateWordMask(userWord, gameWord, enteredLetter);
                } else {
                    userWrongs++;
                    System.out.println(GameCycleHandler.INCORRECT_LETTER_CONST);
                    System.out.println(HangingRackStringGenerator.createHangingRack(userWrongs));
                }
                System.out.println(userWord);
                usedLettersByUser.add(enteredLetter);
            } else {
                System.out.println(GameCycleHandler.ALREADY_ENTERED_LETTER_CONST);
            }
        }
        GameResultHandler.handleGameResult(userWord, gameWord, userWrongs);
    }

    private static boolean isGameContinues(String userWord, String gameWord, int wrongs) {
        return (!UserResultHandler.isUserWin(userWord, gameWord) && !UserResultHandler.isUserLost(wrongs));
    }

    private static boolean isLetterConsistInWord(String word, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }
}
