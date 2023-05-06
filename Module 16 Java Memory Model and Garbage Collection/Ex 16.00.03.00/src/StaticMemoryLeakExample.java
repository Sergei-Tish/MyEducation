import java.util.ArrayList;
import java.util.*;

/**
 * В данном примере несмотря на то, что объект MemoryLeak может быть удален сборщиком мусора после завершения метода createMemoryLeak()
 * и сам объект больше никогда не будет использоваться, данные, хранящиеся в списке DATA, не будут удалены вплоть до завершения программы
 */

public class StaticMemoryLeakExample {

    static class MemoryLeak {
        static List<byte[]> DATA = new LinkedList<>();

        MemoryLeak() {
            for (int i = 0; i < 101; i++) {
                DATA.add(new byte[1024 * 1024]);
            }
        }

        void printDataSize() {
            System.out.println(DATA.size());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(7000);

        for (int i = 0; i < 30; i++) {
            createMemoryLeak();
            Thread.sleep(500);
        }
    }

    static void createMemoryLeak() {
        MemoryLeak memoryLeak = new MemoryLeak();
        memoryLeak.printDataSize();
    }
}
/**
 * Общий совет в данном случае: стараться избегать использования статических полей, в особенности хранящих большой или изменяемый объем данных.
 * Помимо избавления от потенциальных утечек памяти, этот подход может быть полезен и по другим причинам:
 * * * Изменяемые статические поля могут затруднить тестирование, т.к изменения, произведенные одним тестом, неочевидным образом могут быть доступны следующему тесту и влиять на результат его исполнения.
 * * * В многопоточной среде чтение-запись в статическое поле может требовать дополнительной координации (например, с помощью внешнего монитора), усложняющая тем самым код.
 */