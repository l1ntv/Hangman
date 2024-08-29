package GameWord;

import Initializers.DictArrayInitiliazer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordGenerator {
    private final static Random random = new Random();
    private static int MAXIMUM_WORD_INDEX_IN_DICT;
    private static int MINIMAL_WORD_INDEX_IN_DICT;
    private static ArrayList<String> dict = new ArrayList<>();

    private WordGenerator() {
    }

    public static String generate() throws IOException {
        int index = WordGenerator.generateIndex();
        return WordGenerator.findWord(index);
    }

    private static String findWord(int index) throws IOException {
        if (dict.isEmpty()) {
            dict = DictArrayInitiliazer.initilizeDictArrayList(dict);
            if (dict.isEmpty()) {
                return null;
            }
        } else {
            WordGenerator.MINIMAL_WORD_INDEX_IN_DICT = 1;
            WordGenerator.MAXIMUM_WORD_INDEX_IN_DICT = dict.size() - 1;
        }
        return dict.get(index);
    }

    private static int generateIndex() {
        return ((random.nextInt(WordGenerator.MAXIMUM_WORD_INDEX_IN_DICT)) + WordGenerator.MINIMAL_WORD_INDEX_IN_DICT);
    }
}
