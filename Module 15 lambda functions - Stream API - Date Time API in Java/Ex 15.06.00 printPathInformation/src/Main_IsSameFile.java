import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_IsSameFile {
    public static void main(String[] args) {

        Path path1 = null;
        Path path2 = null;
        path1 = Paths.get("D:\\Sergey\\Pictures\\Memasiki\\screen1.jpg");
        path2 = Paths.get("D:\\Sergey\\Pictures\\MyLink.txt");
        try {
            Files.createSymbolicLink(path2, path1);
        } catch (IOException e) {
            System.out.println("Failed to create symbolic link: " + e.getMessage());
        }

        try {
            boolean sameFile = Files.isSameFile(path2, path1); // true
            System.out.println(sameFile);
        } catch (IOException e) {
            System.out.println("MY EXCEPTION: " + e);
        }
//        try {
//            Files.isSameFile(Paths.get("/user/tree/../monkey"), Paths.get("user/monkey")); // true
//        } catch (IOException e) {
//            // Handle file I/O exception
//            System.out.println("MY EXCEPTION: " + e);
//        }

    }
}
