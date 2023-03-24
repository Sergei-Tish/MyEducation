import java.util.HashMap;
import java.util.Map;

public class Main_12_8_6 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(); // строка 1
        for (int i = 1; i <= 10; i++) {
            map.put(i, i * i); // строка 2
        }
        System.out.println(map.get(4)); // строка 3

        // map.get(4) = 16, т.к. запрос не по индексу, а по ключу
    }
}
