package GameWord;

import Constants.AppConstants;
import Initializers.DictArrayInitiliazer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordGenerator {
    private final static Random random = new Random();
    private static ArrayList<String> dict = new ArrayList<>();

    private WordGenerator() {
    }

    public static String generate() throws IOException {
        if (dict.isEmpty()) {
            dict = DictArrayInitiliazer.initilizeDictArrayList(dict);
        }
        int index = WordGenerator.generateIndex();
        return WordGenerator.findWord(index);
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
