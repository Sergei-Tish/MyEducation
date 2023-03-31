import java.util.*;

public class Main3Thread {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 1 часть

        Thread found = new Thread() {
            public void run() {
                long start = System.currentTimeMillis();
                List<Integer> numbers = new ArrayList<>();
                for (
                        int i = 1;
                        i <= 10000000; i++) {
                    numbers.add(i);
                }

                int max = Collections.max(numbers);
                long end = System.currentTimeMillis();
                System.out.println("Max found: " + max + " time: " + (end - start) + " ms");
            }
        };
        found.start();
        // 2 часть
        Thread sorted = new Thread() {
            public void run() {
                long start = System.currentTimeMillis();
                List<Integer> unsorted = new ArrayList<>();
                for (int i = 10000000; i >= 1; i--) {
                    unsorted.add(i);
                }
                Collections.sort(unsorted);
                long end = System.currentTimeMillis();
                System.out.println("List is sorted now time: " + (end - start) + " ms");
            }
        };
        sorted.start();
        // 3 часть
        Thread cleared = new Thread() {
            public void run() {
                long start = System.currentTimeMillis();
                List<Integer> list = new ArrayList<>();
                for (int i = 1; i <= 10000000; i++) {
                    list.add(i);
                }
                while (list.size() != 0) {
                    list.remove(list.size() - 1);
                }
                long end = System.currentTimeMillis();
                System.out.println("List cleared time: " + (end - start) + " ms");
            }

        };
        cleared.start();
        // Итог
        try {
            found.join();
            sorted.join();
            cleared.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms");

        Thread oneThread = new Thread() {
            @Override
            public void run() {
                System.out.println("\n and all in one thread");

                long start = System.currentTimeMillis();

                // 1 часть

                List<Integer> numbers = new ArrayList<>();
                for (int i = 1; i <= 10000000; i++) {
                    numbers.add(i);
                }
                int max = Collections.max(numbers);
                System.out.println("Max found: " + max);

                // 2 часть

                List<Integer> unsorted = new ArrayList<>();
                for (int i = 10000000; i >= 1; i--) {
                    unsorted.add(i);
                }
                Collections.sort(unsorted);
                System.out.println("List is sorted now");

                // 3 часть

                List<Integer> list = new ArrayList<>();
                for (int i = 1; i <= 10000000; i++) {
                    list.add(i);
                }
                while (list.size() != 0) {
                    list.remove(list.size() - 1);
                }
                System.out.println("List cleared");

                // Итог

                long end = System.currentTimeMillis();

                System.out.println("Total time: " + (end - start) + " ms");
            }
        };
        oneThread.start();
    }

}