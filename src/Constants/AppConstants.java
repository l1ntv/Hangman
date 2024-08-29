package Constants;

public class AppConstants {
    public final static int FIRST_INDEX = 0;
    public final static int START_GAME_CHOICE = 1;
    public final static int END_GAME_CHOICE = 2;
    public final static int LOST_COUNT_WRONGS = 9;
    public final static String ERROR_MESSAGE = "Ошибка. Перезапустите игру.";
    public final static String ALREADY_ENTERED_LETTER = "Вы уже вводили эту букву.";
    public final static String INCORRECT_LETTER = "Неправильно!";
    public final static String END_GAME = "Игра завершена.";
    public final static String WIN_MESSAGE = "Вы угадали!";
    public final static String LOST_MESSAGE = "Вы проиграли!";
    public final static String ANSWER_MESSAGE = "Загаданным словом было: ";
    public static final String MASK_SYMBOL = "*";
    public static final String DICT_PATH = "src/resourcer/dict.txt";
    public final static String ENTER_LETTER = "Ввод буквы: ";
    public final static String ENTER_CORRECT_LETTER = "Ошибка: введите русскую букву.";
    public final static String ENTER_ONE_LETTER = "Введите 1 букву";
    public final static String EMPTY_STRING = "";
    public final static String REGEX_RUSSIAN_LETTERS = "[А-Яа-яЁё]";
    public static final String MENU = "Меню:\n1. Начать игру.\n2. Выйти из игры.";
    public static final String ENTER_MENU = "Ввод: ";
    public static final String INCORRECT_CHOICE = "Ввод отсутствующего пункта меню.";
    public static final String ENTER_DIGIT = "Введите цифру.";
    public static final String FIRST_STAGE = "||\n" +
            "||\n" +
            "||\n" +
            "||\n" +
            "||\n" +
            "||";
    public static final String SECOND_STAGE = "||\n" +
            "||\n" +
            "||\n" +
            "||\n" +
            "||\n" +
            "||    || ||";
    public static final String THIRD_STAGE = "||______\n" +
            "||\n" +
            "||\n" +
            "||\n" +
            "||      _\n" +
            "||    || ||";
    public static final String FOURTH_STAGE = "\n" +
            "||______\n" +
            "||\t    0\n" +
            "||\n" +
            "||\n" +
            "||      _\n" +
            "||    || ||";
    public static final String FIFTH_STAGE = "||______\n" +
            "||\t    0\n" +
            "||     \\|\n" +
            "||     \n" +
            "||      _\n" +
            "||    || ||";
    public static final String SIXTH_STAGE = "||______\n" +
            "||\t    0\n" +
            "||     \\|/\n" +
            "||     \n" +
            "||      _\n" +
            "||    || ||";
    public static final String SEVENTH_STAGE = "||______\n" +
            "||\t    0\n" +
            "||     \\|/\n" +
            "||     /\n" +
            "||      _\n" +
            "||    || ||";
    public static final String EIGHTH_STAGE = "||______\n" +
            "||\t    0\n" +
            "||     \\|/\n" +
            "||     / \\\n" +
            "||      _\n" +
            "||    || ||";
    public static final String NINTH_STAGE = "||______\n" +
            "||\t    0\n" +
            "||     \\|/\n" +
            "||     / \\\n" +
            "||      \n" +
            "||    ";

    private AppConstants() {}
}
