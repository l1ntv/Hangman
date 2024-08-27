package WordHandler;

public class WordMaskGenerator {
    public static String createWordMask(String word) {
        StringBuilder wordMask = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            wordMask.append("*");
        }
        return wordMask.toString();
    }
}
