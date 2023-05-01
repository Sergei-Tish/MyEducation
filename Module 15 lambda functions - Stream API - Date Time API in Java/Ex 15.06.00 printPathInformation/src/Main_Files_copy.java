import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_Files_copy {
    public static void main(String[] args) {


        for (int i = 2; i < 10; i++) {
            try {
                Files.copy(Paths.get("D:\\Sergey\\Pictures\\Memasiki\\screen1.jpg"), Paths.get("D:\\Sergey\\Pictures\\Memasiki\\screen" + i + ".jpg"));
    //            Files.copy(Paths.get("panda/bamboo.txt"), Paths.get("panda-save/bamboo.txt"));
            } catch (IOException e) {
                // Handle file I/O exception
                System.out.println("EXCEPTION: " + e);
            }
        }

    }
}
