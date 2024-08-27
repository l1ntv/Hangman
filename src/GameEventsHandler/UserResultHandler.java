package GameEventsHandler;

public class UserResultHandler {
    private final static int MAXIMUM_WRONGS_COUNT = 9;

    public static boolean isUserWin(String userWord, String gameWord) {
        return (userWord.equals(gameWord));
    }

    public static boolean isUserLost(int wrongs) {
        return (wrongs >= UserResultHandler.MAXIMUM_WRONGS_COUNT);
    }
}
