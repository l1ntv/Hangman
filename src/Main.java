import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {

    private final static String MENU_CONST = "Меню:\n1. Начать игру.\n2. Выйти из игры.";
    private final static String END_GAME_CONST = "Игра завершена.";
    private final static String ENTER_MENU_CONST = "Ввод: ";
    private final static String YOU_WIN_CONST = "Вы угадали!";
    private final static String YOU_LOST_CONST = "Вы проиграли!";
    private final static String ALREADY_ENTERED_LETTER_CONST = "Вы уже вводили эту букву.";
    private final static String INCORRECT_LETTER_CONST = "Неправильно!";
    private final static String ERROR_MESSAGE_CONST = "Ошибка. Перезапустите игру.";
    private final static String ENTER_CORRECT_LETTER_CONST = "Ошибка: введите русскую букву.";
    private final static String ENTER_LETTER_CONST = "Ввод буквы: ";
    private final static String GAME_WORD_IS_CONST = "Загаданным словом было: ";
    private final static int MINIMAL_WORD_INDEX_IN_DICT = 1;
    private final static int MAXIMUM_WORD_INDEX_IN_DICT = 25;
    private final static int START_GAME_CHOICE_MENU = 1;
    private final static int END_GAME_CHOICE_MENU = 2;
    private final static int MAXIMUM_WRONGS_COUNT = 9;
    private final static Random random = new Random();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println(Main.MENU_CONST);
        int menuChoice = 0;
        while (!Main.isMenuChoiceCorrect(menuChoice)) {
            System.out.print(Main.ENTER_MENU_CONST);
            menuChoice = in.nextInt();
        }
        if (menuChoice == Main.END_GAME_CHOICE_MENU) {
            System.out.println(Main.END_GAME_CONST);
            in.close();
            return;
        } else {
            while (menuChoice == Main.START_GAME_CHOICE_MENU) {
                Set<Character> usedLettersByUser = new HashSet<>();
                char enteredLetter;
                int userWrongs = 0;
                String gameWord = Main.findRandomWord().toLowerCase();
                if (gameWord == null) {
                    System.out.println(Main.ERROR_MESSAGE_CONST);
                    return;
                }
                String userWord = Main.createWordMask(gameWord);
                System.out.println(userWord);
                while (Main.isGameContinues(userWord, gameWord, userWrongs)) {
                    System.out.print(Main.ENTER_LETTER_CONST);
                    enteredLetter = Character.toLowerCase(in.next().charAt(0));
                    while (!Main.isEnteredCharacterCorrect(enteredLetter)) {
                        System.out.println(Main.ENTER_CORRECT_LETTER_CONST);
                        System.out.print(Main.ENTER_LETTER_CONST);
                        enteredLetter = Character.toLowerCase(in.next().charAt(0));
                    }
                    if (!usedLettersByUser.contains(enteredLetter)) {
                        if (Main.isLetterConsistInWord(gameWord, enteredLetter)) {
                            userWord = Main.updateWordMask(userWord, gameWord, enteredLetter);
                        } else {
                            userWrongs++;
                            System.out.println(Main.INCORRECT_LETTER_CONST + "\n" + Main.createHangingRack(userWrongs));
                        }
                        System.out.println(userWord);
                        usedLettersByUser.add(enteredLetter);
                    } else {
                        System.out.println(Main.ALREADY_ENTERED_LETTER_CONST);
                    }
                }
                if (Main.isUserWin(userWord, gameWord)) {
                    System.out.println(Main.YOU_WIN_CONST);
                } else if (Main.isUserLost(userWrongs)) {
                    System.out.println(Main.YOU_LOST_CONST);
                    System.out.println(Main.GAME_WORD_IS_CONST + gameWord);
                }
                menuChoice = 0;
                System.out.println(Main.MENU_CONST);
                while (!Main.isMenuChoiceCorrect(menuChoice)) {
                    System.out.print(Main.ENTER_MENU_CONST);
                    menuChoice = in.nextInt();
                }
            }
        }
        System.out.println(Main.END_GAME_CONST);
        in.close();
        return;
    }

    private static boolean isEnteredCharacterCorrect(char letter) {
        String regex = "[А-Яа-яЁё]";
        return Pattern.matches(regex, String.valueOf(letter));
    }

    private static boolean isGameContinues(String userWord, String gameWord, int wrongs) {
        return (!Main.isUserWin(userWord, gameWord) && !Main.isUserLost(wrongs));
    }

    private static boolean isUserWin(String userWord, String gameWord) {
        return (userWord.equals(gameWord));
    }

    private static boolean isUserLost(int wrongs) {
        return (wrongs >= MAXIMUM_WRONGS_COUNT);
    }

    private static boolean isMenuChoiceCorrect(int gameChoice) {
        return (gameChoice == Main.START_GAME_CHOICE_MENU || gameChoice == Main.END_GAME_CHOICE_MENU);
    }

    private static String findRandomWord() throws IOException {
        int wordPosition = Main.findWordPosition();
        BufferedReader br = new BufferedReader(new FileReader("src/dict.txt"));
        String line;
        int currentLineNumber = 0;
        while ((line = br.readLine()) != null) {
            currentLineNumber++;
            if (currentLineNumber == wordPosition) {
                return line.trim();
            }
        }
        return null;
    }

    private static int findWordPosition() {
        return (random.nextInt(Main.MAXIMUM_WORD_INDEX_IN_DICT)) + Main.MINIMAL_WORD_INDEX_IN_DICT;
    }

    private static String createWordMask(String word) {
        StringBuilder wordMask = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            wordMask.append("*");
        }
        return wordMask.toString();
    }

    private static boolean isLetterConsistInWord(String word, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }

    private static String updateWordMask(String userWord, String word, char letter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < userWord.length(); i++) {
            if (word.charAt(i) == letter) {
                stringBuilder.append(letter);
            } else {
                stringBuilder.append(userWord.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static String createHangingRack(int stage) {
        StringBuilder stringBuilder = new StringBuilder();
        if (stage >= 1) {
            stringBuilder.append("__________\n");
        }

        if (stage >= 2) {
            stringBuilder.append("|        |\n");
        }

        if (stage >= 3) {
            stringBuilder.append("|        0\n");
        }

        if (stage >= 4) {
            stringBuilder.append("|       /|\\\n");
        }

        if (stage >= 5) {
            stringBuilder.append("|       / \\\n");
        }

        if (stage >= 6) {
            stringBuilder.append("|\n");
        }

        if (stage >= 7) {
            stringBuilder.append("|\n");
        }

        if (stage >= 8) {
            stringBuilder.append("|\n");
        }

        if (stage >= 9) {
            stringBuilder.append("==========\n");
        }

        return stringBuilder.toString();
    }
}