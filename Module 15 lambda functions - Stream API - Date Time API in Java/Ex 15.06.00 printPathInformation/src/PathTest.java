import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {
        printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
        System.out.println();
        printPathInformation(Paths.get("c:/zoo/armadillo/shells.txt"));
        System.out.println();
        printPathInformation(Paths.get("zoo/armadillo/shells.txt"));
    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());

        Path currentPath = path;
        while ((currentPath = currentPath.getParent()) != null) {
            System.out.print("  |||  Current parent is: " + currentPath);
        }
        System.out.println();
        System.out.println(currentPath + "     " + path);
    }
}