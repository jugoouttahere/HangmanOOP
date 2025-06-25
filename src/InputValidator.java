import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {

    public String getValidateInput() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput = br.readLine();

            if (userInput.equalsIgnoreCase("В")) {
                System.out.println("Выход из игры...\nДо встречи!");
            } else if (userInput.equalsIgnoreCase("Н")) {

            } else {
                System.out.println("Некорректный ввод!");
            }
        } catch (IOException e) {
            System.out.println("Что то пошло не так!");
        }

        return "";
    }
}
