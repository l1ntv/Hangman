package GameEvents;

import Constants.AppConstants;

public class GameState {

    private GameState() {
    }

    public static void determine(String word, String gameWord, int wrongsCount) {
        if (GameState.isWin(word, gameWord)) {
            GameState.displayWinMessage();
        } else {
            GameState.displayLostMessage(gameWord);
        }
    }

    public static boolean isWin(String word, String gameWord) {
        return (word.equals(gameWord));
    }

    public static boolean isLost(int wrongsCount) {
        return (wrongsCount == AppConstants.LOST_COUNT_WRONGS);
    }

    private static void displayWinMessage() {
        System.out.println(AppConstants.WIN_MESSAGE);
    }

    private static void displayLostMessage(String gameWord) {
        System.out.println(AppConstants.LOST_MESSAGE);
        System.out.print(AppConstants.ANSWER_MESSAGE);
        System.out.println(gameWord);
    }
}
