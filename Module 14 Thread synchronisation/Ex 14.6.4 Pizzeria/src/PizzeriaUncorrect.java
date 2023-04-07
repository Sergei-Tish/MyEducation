import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class PizzeriaUncorrect implements Runnable {
    BlockingDeque<String> ordersQueue = new LinkedBlockingDeque<>(2);

    void order(String pizzaName) throws InterruptedException {
        if (ordersQueue.offer(pizzaName, 500, TimeUnit.MILLISECONDS)) {
            System.out.println(pizzaName + " is delivered");
        } else if (ordersQueue.offer(pizzaName, 250, TimeUnit.MILLISECONDS)) {
            System.out.println(pizzaName + " is delivered");
        } else {
            System.out.println(pizzaName + " is NOT delivered");
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            ordersQueue.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}