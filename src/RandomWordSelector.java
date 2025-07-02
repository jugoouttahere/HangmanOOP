import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWordSelector {
    private final List<String> DICTIONARY = new ArrayList<>();

    public RandomWordSelector() {
        readWordsFromFile();
    }

    private void readWordsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/content/dictionary.txt"))) {
            br.lines().forEach(DICTIONARY::add);
            if (DICTIONARY.isEmpty()) {
                throw new RuntimeException("Файл с словарем пуст!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Что то пошло не так!");
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        return DICTIONARY.get(random.nextInt(DICTIONARY.size()));
    }
}
