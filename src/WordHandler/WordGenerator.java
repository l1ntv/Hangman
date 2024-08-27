package WordHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WordGenerator {
    private final static Random random = new Random();
    private final static int MINIMAL_WORD_INDEX_IN_DICT = 1;
    private final static int MAXIMUM_WORD_INDEX_IN_DICT = 25;
    public static String findRandomWord() throws IOException {
        int wordPosition = WordGenerator.findWordPosition();
        BufferedReader br = new BufferedReader(new FileReader("src/resourcer/dict.txt"));
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
        return (random.nextInt(WordGenerator.MAXIMUM_WORD_INDEX_IN_DICT)) + WordGenerator.MINIMAL_WORD_INDEX_IN_DICT;
    }
}
