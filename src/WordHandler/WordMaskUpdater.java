package WordHandler;

public class WordMaskUpdater {
    public static String updateWordMask(String userWord, String word, char letter) {
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
}
