import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWordSelector {
    private final List<String> DICTIONARY = new ArrayList<>();
    private final String FILE_PATH;

    public RandomWordSelector(String filePath) {
        this.FILE_PATH = filePath;
        readWordsFromFile();
    }

    private void readWordsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.lines().forEach(DICTIONARY::add);
            if (DICTIONARY.isEmpty()) {
                System.out.println("Словарь пуст!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        return DICTIONARY.get(random.nextInt(DICTIONARY.size()));
    }

}
