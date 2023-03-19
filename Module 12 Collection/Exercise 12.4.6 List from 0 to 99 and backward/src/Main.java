import java.util.*;

// Exercise 12.4.6 List from 0 to 99 and backward

public class Main {
    /*
    Напишите программу, которая создает лист и заполняет его последовательно числами в порядке от 0 до 99.
    Затем, не создавая новый лист, сделайте так, чтобы эти же числа располагались в обратом порядке — от 99 до 0 (не используя Collections.sort()).
     */

    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            integerArrayList.add(i);
        }
        System.out.println(integerArrayList);

        for (int i = 99, k = 0; i >= 0; k++, i--) {
            integerArrayList.set(k, i);
        }

        System.out.println(integerArrayList);
        System.out.println(Objects.hash(integerArrayList));

        List<Integer> integerList = integerArrayList;
        System.out.println(Objects.hash(integerList));
        main2();
    }

    public static void main2() {
        Set<String> set = new HashSet<>();

        set.add("Hello");
        set.add("Hello again");
        set.add("Hello");
        set.add("22");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("3");

        System.out.println(set);
    }
}


