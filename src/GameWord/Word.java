package GameWord;

import Constants.AppConstants;
import Initializers.DictArrayInitiliazer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Word {
    private final static Random random = new Random();
    private static ArrayList<String> dict = new ArrayList<>();

    private Word() {
    }

    public static String generate() throws IOException {
        if (dict.isEmpty()) {
            dict = DictArrayInitiliazer.initilizeDictArrayList(dict);
        }
        int index = Word.generateIndex();
        return Word.findWord(index);
    }

    public static boolean isLetterInWord(String word, String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(AppConstants.FIRST_INDEX)) {
                return true;
            }
        }
        return false;
    }

    private static String findWord(int index) throws IOException {
        if (dict.isEmpty()) {
            return null;
        }
        return dict.get(index);
    }

    private static int generateIndex() {
        return ((random.nextInt(dict.size() - 1)) + AppConstants.FIRST_INDEX);
    }
}
