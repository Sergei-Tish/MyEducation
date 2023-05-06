import java.util.*;
/**
 * Утечка через внутренний класс
 * Давайте на практике рассмотрим один из классических примеров утечки памяти, который довольно легко допустить:
 * */
public class MemoryLeakExample {

    // Класс, реализующий циклическую коллекцию
    static class CyclicCollection {
        private final List<byte[]> list = new ArrayList<>(10);

        CyclicCollection() {
            // Займем ~10Mb памяти
            for (int i = 0; i < 10; i++) {
                list.add(new byte[1024 * 1024]);
            }
        }

        Element getElement(int index) {
            // Возвращаем один из десяти элементов, хранящихся
            // в списке. В качестве индекса возьмём
            // остаток от деления на 10. Таким образом внешнему
            // наблюдателю будет казаться, что в коллекции
            // бесконечное количество повторяющихся элементов.
            return new Element(list.get(index % 10));
        }


        // Внутренний класс, хранящий в себе
        // элемент коллекции
        class Element {
            final byte[] data;

            Element(byte[] data) {
                this.data = data;
            }
        }
    }
    /**
     * Решение указывают в скринкасте - сделать класс Element - static. Что бы он удерживал в себе ссылку на Внешний класс.
     * Но у меня на ПК не удалось реализовать ошибку,
     * Я выставил Program argument: -XX: +HeapDumpUnOutOfMemoryError -Xmx100m.
     * */

    public static void main(String[] args) throws Exception {
        // Список, в котором будем хранить по одному элементу
        // из ста циклических коллекций
        List<CyclicCollection.Element> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            CyclicCollection collection = new CyclicCollection();
            list.add(collection.getElement(i));
            Thread.sleep(1000);
        }
        Thread.sleep(60000);
    }
}