import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector randomWordSelector = new RandomWordSelector("src/content/dictionary.txt");
    private final WordMask wordMask = new WordMask();

    public void start() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            int numberOfMistakes;

            while (true) {
                System.out.println("[Н]ачать игру / [В]ыйти из игры");
                userInput = br.readLine();

                if (userInput.equalsIgnoreCase("В")) {
                    System.out.println("Выход из игры...\nДо встречи!");

                } else if (userInput.equalsIgnoreCase("Н")) {
                    numberOfMistakes = 0;
                    String letter;
                    String randomWord = randomWordSelector.getRandomWord();
                    System.out.println("Слово загадано!");
                    wordMask.printMask();

                    while (!wordMask.isWordGuessed()) {
                        System.out.println("Угадай букву!");
                        letter = br.readLine();

                        if (wordMask.isLetterUsed(letter)) {
                            System.out.printf("Вы уже использовали букву - '%s' \n", letter.toUpperCase());
                        } else {
                            wordMask.addToUsedLetter(letter);
                            if (wordMask.containLetterInWord(letter)) {
                                System.out.println("Вы угадали букву!");
                                System.out.print("Слово: ");
                                wordMask.updateMask(letter.charAt(0));
                                wordMask.printMask();
                            } else {
                                System.out.println("Вы не угадали... Попробуйте еще");
                                numberOfMistakes++;
                                System.out.printf("Ошибок %d/6\n", numberOfMistakes);
                                hangmanDrawer.printHangman(numberOfMistakes);
                            }
                        }
                    }

                    if (numberOfMistakes > 5) {
                        System.out.println("Вы проиграли(");
                        System.out.printf("Было загадано слово: ", randomWord);
                        break;
                    } else if (wordMask.isWordGuessed()) {
                        System.out.printf("Поздравляем! Вы угадали слово: ");
                    }

                } else {
                    System.out.println("Некорректный ввод!");
                }
            }

        } catch (IOException e) {
            System.out.println("Что то пошло не так!");
        }

    }
}
