package GameEventsHandler;

public class GameResultHandler {
    private final static String YOU_WIN_CONST = "Вы угадали!";
    private final static String YOU_LOST_CONST = "Вы проиграли!";
    private final static String GAME_WORD_IS_CONST = "Загаданным словом было: ";

    public static void handleGameResult(String userWord, String gameWord, int userWrongs) {
        if (UserResultHandler.isUserWin(userWord, gameWord)) {
            System.out.println(GameResultHandler.YOU_WIN_CONST);
        } else if (UserResultHandler.isUserLost(userWrongs)) {
            System.out.println(GameResultHandler.YOU_LOST_CONST);
            System.out.print(GameResultHandler.GAME_WORD_IS_CONST);
            System.out.println(gameWord);
        }
    }
}
