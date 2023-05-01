import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_Files_move {
    public static void main(String[] args) {


        for (int i = 2; i < 3; i++) {
            try {
                Files.move(Paths.get("K:\\Test_for_idea\\papka1"), Paths.get("K:\\Test_for_idea\\papka1" + i));
                Files.move(Paths.get("K:\\Test_for_idea\\papka12\\fileTest1.txt"), Paths.get("K:\\Test_for_idea\\papka12\\fileTest1" +i+ ".txt"));

                //            Files.copy(Paths.get("panda/bamboo.txt"), Paths.get("panda-save/bamboo.txt"));
            } catch (IOException e) {
                // Handle file I/O exception
                System.out.println("EXCEPTION: " + e);
            }
        }

    }
}
