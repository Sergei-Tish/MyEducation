import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_Files_delete {
    public static void main(String[] args) {


        for (int i = 2; i < 3; i++) {
            try {
                Files.delete(Paths.get("K:\\Test_for_idea\\papka1"));
                //            Files.copy(Paths.get("panda/bamboo.txt"), Paths.get("panda-save/bamboo.txt"));
            } catch (IOException e) {
                // Handle file I/O exception
                System.out.println("EXCEPTION: " + e);
            }

            try {
                Files.deleteIfExists(Paths.get("K:\\Test_for_idea\\papka1\\fileTest1.txt"));
            } catch (IOException e) {
                System.out.println("EXCEPTION2: " + e);
            }

        }

    }
}
