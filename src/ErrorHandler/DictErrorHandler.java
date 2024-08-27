package ErrorHandler;

public class DictErrorHandler {
    private final static String ERROR_MESSAGE_CONST = "Ошибка. Перезапустите игру.";

    public static void dictErrorHandler(String gameWord) {
        if (gameWord == null) {
            System.out.println(DictErrorHandler.ERROR_MESSAGE_CONST);
            return;
        }
    }
}

