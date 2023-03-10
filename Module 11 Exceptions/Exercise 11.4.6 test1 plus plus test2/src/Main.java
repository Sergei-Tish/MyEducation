import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("test1.txt");
        file.createNewFile();
        try (FileReader fr1 = new FileReader("test1.txt")) {
            try (FileReader fr2 = new FileReader("test2.txt")) {
            } catch (IOException e) {
                System.out.print("test2");
            }
            System.out.print("+");
        } catch (FileNotFoundException e) {
            System.out.print("test1");
        }
        file.delete();
    }
}
