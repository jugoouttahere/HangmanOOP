import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector randomWordSelector = new RandomWordSelector("dictionary.txt");
    private final WordMask wordMask = new WordMask(randomWordSelector.getRandomWord());

    public void start() {
        System.out.println("[Н]ачать игру / [В]ыйти из игры");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput = br.readLine();

            if (userInput.equalsIgnoreCase("В")) {
                System.out.println("Выход из игры...\nДо встречи!");
            } else if (userInput.equalsIgnoreCase("Н")) {
                while (true) {

                }
            } else {
                System.out.println("Некорректный ввод!");
            }
        } catch (IOException e) {
            System.out.println("Что то пошло не так!");
        }

    }
}
