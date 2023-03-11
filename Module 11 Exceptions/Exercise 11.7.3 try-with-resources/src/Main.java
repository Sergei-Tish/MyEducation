import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Посмотреть ответ для самопроверки
 * */

public class Main {
    public String input() throws MyException {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (s.equals("")) {
            throw new MyException("String can not be empty!");
        }
        return s;
    }
}
