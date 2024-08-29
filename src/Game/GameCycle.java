package Game;

import Constants.AppConstants;
import Errors.DictErrorHandler;
import GameEvents.GameState;
import Initializers.HangingRackArrayInitiliazer;
import Input.Game;
import GameWord.Word;
import GameWord.WordMask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameCycle {

    private static ArrayList<String> hangingRack = new ArrayList<>();

    private GameCycle() {
    }

    public static void start() throws IOException {
        Set<String> usedLettersByUser = new HashSet<>();
        int userWrongs = 0;
        String enteredLetter;
        if (hangingRack.isEmpty()) {
            hangingRack = HangingRackArrayInitiliazer.initilizeHangingRackArray(hangingRack);
        }
        String gameWord = Word.generate();
        DictErrorHandler.handle(gameWord);
        String userWord = WordMask.create(gameWord);
        WordMask.display(userWord);
        while (GameState.isGameContinues(userWord, gameWord, userWrongs)) {
            enteredLetter = Game.input();
            if (!usedLettersByUser.contains(enteredLetter)) {
                if (Word.isLetterInWord(gameWord, enteredLetter)) {
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
}
