import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector randomWordSelector = new RandomWordSelector("dictionary.txt");
    private final WordMask wordMask = new WordMask(randomWordSelector.getRandomWord());

    public void start() {
        System.out.println("[Н]ачать игру / [В]ыйти из игры");

    }
}
