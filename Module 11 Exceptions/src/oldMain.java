import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class oldMain {
    private Throwable e;

    public String input() throws MyException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                System.out.println(e.getMessage());
            }
        }

        if (s.equals("")) {
            throw new MyException("String can not be empty!");
            reader.close();
        } catch (IOException e) {}

        return s;
    }
}

