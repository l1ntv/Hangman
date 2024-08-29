package Game.GameWord;

import Constants.AppConstants;

public class WordMask {

    private WordMask() {
    }

    public static String create(String word) {
        StringBuilder wordMask = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            wordMask.append(AppConstants.MASK_SYMBOL);
        }
        return wordMask.toString();
    }

    public static String update(String userWord, String word, String letter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < userWord.length(); i++) {
            if (word.charAt(i) == letter.charAt(AppConstants.FIRST_INDEX)) {
                stringBuilder.append(letter);
            } else {
                stringBuilder.append(userWord.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void display(String wordMask) {
        System.out.println(wordMask);
    }
}
