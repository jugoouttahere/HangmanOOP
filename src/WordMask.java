import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordMask {
    private String word;
    private final StringBuilder mask = new StringBuilder();
    private final Set<String> uniqueWordsLetters = new HashSet<>();
    private final Set<String> usedLetters = new HashSet<>();


    public void setWord(String word) {
        this.word = word;
        this.mask.append("*".repeat(word.length()));
        Collections.addAll(uniqueWordsLetters, word.split(""));
    }

    public void printMask() {
        System.out.print(mask);
    }

    public void updateMask(String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).equalsIgnoreCase(letter)) {
                mask.setCharAt(i, letter.charAt(0));
            }
        }
    }

    public boolean containsLetterInWord(String letter) {
        return uniqueWordsLetters.contains(letter);
    }

    public void addToUsedLetters (String letter) {
        usedLetters.add(letter);
    }

    public boolean isLetterUsed(String letter) {
        return usedLetters.contains(letter);
    }

    public void defaultState() {
        uniqueWordsLetters.clear();
        usedLetters.clear();
    }
}
