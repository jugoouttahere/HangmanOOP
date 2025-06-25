import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWordSelector {
    private final List<String> DICTIONARY = new ArrayList<>();
    private final String FILE_NAME;

    public RandomWordSelector(String fileName) {
        this.FILE_NAME = fileName;
        readWordsFromFile();
    }

    private void readWordsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            br.lines().forEach(DICTIONARY::add);
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
