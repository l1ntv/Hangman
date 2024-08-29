package Game;

import Constants.AppConstants;
import Errors.DictErrorHandler;
import GameEvents.GameState;
import Initializers.HangingRackArrayInitiliazer;
import Input.Game;
import GameWord.WordGenerator;
import GameWord.WordMask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameCycleStarter {

    private static ArrayList<String> hangingRack = new ArrayList<>();

    private GameCycleStarter() {
    }

    public static void execute() throws IOException {
        Set<String> usedLettersByUser = new HashSet<>();
        int userWrongs = 0;
        String enteredLetter;
        if (hangingRack.isEmpty()) {
            hangingRack = HangingRackArrayInitiliazer.initilizeHangingRackArray(hangingRack);
        }
        String gameWord = WordGenerator.generate();
        DictErrorHandler.handle(gameWord);
        String userWord = WordMask.create(gameWord);
        WordMask.display(userWord);
        while (GameCycleStarter.isGameContinues(userWord, gameWord, userWrongs)) {
            enteredLetter = Game.input();
            if (!usedLettersByUser.contains(enteredLetter)) {
                if (GameCycleStarter.isLetterInWord(gameWord, enteredLetter)) {
                    userWord = WordMask.update(userWord, gameWord, enteredLetter);
                } else {
                    userWrongs++;
                    System.out.println(AppConstants.INCORRECT_LETTER);
                    System.out.println(hangingRack.get(userWrongs - 1));
                }
                WordMask.display(userWord);
                usedLettersByUser.add(enteredLetter);
            } else {
                System.out.println(AppConstants.ALREADY_ENTERED_LETTER);
            }
            System.out.println("Используемые буквы: " + String.join(", ", usedLettersByUser));
        }
        GameState.determine(userWord, gameWord, userWrongs);
    }

    private static boolean isGameContinues(String userWord, String gameWord, int wrongs) {
        return (!GameState.isWin(userWord, gameWord) && !GameState.isLost(wrongs));
    }

    private static boolean isLetterInWord(String word, String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(AppConstants.FIRST_INDEX)) {
                return true;
            }
        }
        return false;
    }
}
