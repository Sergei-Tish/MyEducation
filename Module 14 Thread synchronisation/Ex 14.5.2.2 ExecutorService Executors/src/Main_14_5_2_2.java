import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main_14_5_2_2 extends Thread {
    private static int count = 0;
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        MyThread myThread = new MyThread();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                new MyThread().start();
            });
        }

        try {
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Все потоки завершили работу за " + duration + " миллисекунд");

    }

    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                int a = 1 + i;
            }
            System.out.println("Executing " + Main_14_5_2_2.count++);
        }
    }
}
