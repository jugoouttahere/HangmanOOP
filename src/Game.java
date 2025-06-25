public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector randomWordSelector = new RandomWordSelector("dictionary.txt");
    private final WordMask wordMask = new WordMask(randomWordSelector.getRandomWord());

    public void start() {

    }
}
