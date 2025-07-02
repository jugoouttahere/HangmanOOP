import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector randomWordSelector =new RandomWordSelector();
    private final WordMask wordMask = new WordMask();

    public void start() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            int maxMistakes = 6;
            int mistakesCount = 0;

            while (true) {
                System.out.println("\nНачать новую игру? (Да/ Нет)");
                userInput = br.readLine();
                if (userInput.equalsIgnoreCase("да")) {
                    mistakesCount = 0;
                    wordMask.defaultState();
                    String letter;
                    String randomWord = randomWordSelector.getRandomWord();
                    wordMask.setWord(randomWord);
                    System.out.println("Слово загадано!");

                    while (mistakesCount != maxMistakes) {
                        System.out.println("\nВведите букву!");
                        letter = br.readLine();
                        //TODO VALIDATE

                        if (wordMask.isLetterUsed(letter)) {
                            System.out.printf("Вы уже использовали букву - '%s'", letter.toUpperCase());
                        } else {
                            wordMask.addToUsedLetters(letter);
                            if (wordMask.containsLetterInWord(letter)) {
                                System.out.println("Вы угадали букву!");
                                wordMask.updateMask(letter);
                                System.out.print("Слово: ");
                                wordMask.printMask();
                            } else {
                                mistakesCount++;
                                System.out.printf("Вы не угадали! использовано попыток %d/6\n", mistakesCount);
                                hangmanDrawer.printHangman(mistakesCount);
                            }
                        }
                    }
                    System.out.println("Вы проиграли!");
                    System.out.printf("Было загадано слово: %s", randomWord);

                } else if (userInput.equalsIgnoreCase("нет")) {
                    System.out.println("Выход из игры...");
                    break;
                } else {
                    System.out.println("Некорректный ввод! Введите [Да] или [Нет]");
                }
            }

        } catch (IOException e) {
            System.out.println("Что то пошло не так!");
        }
    }
}
