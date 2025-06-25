public class HangmanDrawer {
    private final String[] HANGMAN_STATE = {
            " +---+\n |   |\n |   O\n |    \n |    \n =========",

            " +---+\n |   |\n |   O\n |    \n |    \n =========",

            " +---+\n |   |\n |   O\n |   |\n |    \n =========",

            " +---+\n |   |\n |   O\n |  /|\n |    \n =========",

            " +---+\n |   |\n |   O\n |  /|\"\n |  /  \n =========",

            " +---+\n |   |\n |   O\n |  /|\"\n |  / \"\n ========="
    };

    public void printHangmanDraw(int numberOfMistakes) {
        System.out.println(HANGMAN_STATE[numberOfMistakes]);
    }
}
