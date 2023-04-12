import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Напишите пример вызова данного метода, используя лямбда-выражение:
 */
public class Main_15_02_03 {
    public static void main(String[] args) {
        Main_15_02_03 main = new Main_15_02_03();
        Workable worker = Math::sqrt;

        System.out.println(doubleFromString(9, worker));


        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        Collections.sort(strings, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        System.out.println(strings);
        int index = strings.indexOf("is");
        System.out.println(index);
    }

    public static double doubleFromString(int value, Workable worker) {
        return worker.rework(value);
    }
}


interface Workable {
    double rework(int value);
}