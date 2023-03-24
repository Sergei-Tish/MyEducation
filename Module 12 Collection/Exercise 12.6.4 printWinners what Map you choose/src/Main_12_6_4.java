import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main_12_6_4 {
    public int lok (Long Trully) {
        return 0;
    };
    public static void main(String[] args) {
        long newLong = 34344L;

        Map<Integer, String> winners = new HashMap<>(); // ваш код тут

        winners.put(3, "Вася");
        winners.put(1, "Федя");
        winners.put(2, "Антон");

        printWinners(winners);
    }

    private static void printWinners(Map<Integer, String> winners) {
        for (Map.Entry<Integer, String> entry : winners.entrySet()) {
            System.out.println(entry.getKey() + " место занял " + entry.getValue());
        }
    }

    // Верный ответ TreeMap
}
