import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLeakExample {
    static class Job implements Runnable {
        private static final ThreadLocal<List<Object>> LOCAL_DATA =
                ThreadLocal.withInitial(ArrayList::new);

        //        @Override
//        public void run() {
//            List<Object> objects = LOCAL_DATA.get();
//            objects.add(new byte[10024 * 10024]);
//        }
        /** РЕШЕНИЕ */@Override
        public void run() {
            try {
                List<Object> objects = LOCAL_DATA.get();
                objects.add(new byte[10024 * 10024]);
            } finally {
                LOCAL_DATA.remove();
            }
        }
    }

    public static void main(String[] args) {
        int count = 1;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Job());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(count++);
        }

        executor.shutdown();

        // ...
    }
}