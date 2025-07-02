import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {

    public boolean isValidate(String letter) {

        if (letter.isEmpty()) {
            System.out.println("Вы ничего не ввели!");
            return false;
        }

        if (letter.length() != 1) {
            System.out.println("Нужно ввести только ОДНУ букву!");
            return false;
        }

        char inputChar = Character.toLowerCase(letter.charAt(0));

    if (!((inputChar >= 'а' && inputChar <= 'я') || inputChar == 'ё' || inputChar == 'Ё')) {
            System.out.println("Нужно ввести русскую букву!");
            return false;
        }

        return true;
    }
}
