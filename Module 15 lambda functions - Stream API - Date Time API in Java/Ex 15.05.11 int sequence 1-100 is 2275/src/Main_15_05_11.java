import java.util.stream.IntStream;

/**
 * Задание 15.5.11
 * Решите задачу при помощи стримов:
 *
 * Сгенерируйте последовательность чисел от 1 до 100 включительно, ограничьте ее последними 50 числами,
 * оставьте только те числа, которые делятся без остатка на 2 или на 5, и посчитайте сумму полученных чисел.
 * В ответе у вас должно выйти 2275.
 * */

public class Main_15_05_11 {
    public static void main(String[] args) {

        IntStream integerStream = IntStream.iterate(1, integer -> integer+1).skip(50).limit(50).filter(i -> i%2 == 0 || i%5 == 0);
        System.out.println(integerStream.sum()); // 2275

    }
}
