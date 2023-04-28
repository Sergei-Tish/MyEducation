import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Subpath {
    public static void main(String[] args) {

//        Path path = Paths.get("/mammal/carnivore/raccoon.image");
//        System.out.println("Path is: " + path);
//
//        System.out.println("Subpath from 0 to 3 is: " + path.subpath(0, 3));
//        System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
//        System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));

        try {
            System.out.println(Paths.get("K:\\IdeaProjects\\GitTest\\GitTest.java").toRealPath());
            System.out.println(Paths.get("..\\..\\IdeaProjects\\GitTest\\GitTest.java").toRealPath());
            System.out.println(Paths.get("..\\Hello\\Hello.iml").toRealPath());
            System.out.println(Paths.get("..\\Hel.iml").toRealPath());
            System.out.println(Paths.get("..\\Hello\\Hello.iml").toRealPath());
            System.out.println(Paths.get("..\\Hello\\Hello.iml").toRealPath());
        } catch (IOException e) {
            // обработка ошибки
            System.out.println(e);
        }
    }
}
