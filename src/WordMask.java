import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordMask {
    private final String word;
    private final StringBuilder mask = new StringBuilder();
    private final Set<String> usedLetters = new HashSet<>();
    private final Set<String> wordLetters = new HashSet<>();

    public WordMask(String word) {
        this.word = word;
        this.mask.append("*".repeat(word.length()));
        Collections.addAll(wordLetters, word.split(""));
    }

    public void printMask() {
        System.out.println(mask);
    }

    public void updateMask(Character letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                mask.setCharAt(i, letter);
            }
        }
    }

    public boolean containLetterInWord(String letter) {
        return wordLetters.contains(letter);
    }

    public void addToUsedLetter(String letter) {
        usedLetters.add(letter);
    }

    public boolean isLetterUsed(String letter) {
        return usedLetters.contains(letter);
    }

    public boolean isWordGuessed() {
        return word.equalsIgnoreCase(mask.toString());
    }

}
