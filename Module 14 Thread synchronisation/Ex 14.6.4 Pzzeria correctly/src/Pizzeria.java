import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/** копировал это из решения 14.6.4 */

public class Pizzeria {
    public long START_TIME;
    BlockingDeque<Order> orderQueue = new LinkedBlockingDeque<>(2);

    public Pizzeria() {
        START_TIME = System.currentTimeMillis();
        new Delivery().start();
        new Delivery().start();
    }

    public void order(String pizzaName) throws InterruptedException {
        orderQueue.put(new Order(pizzaName));
    }
    class Delivery extends Thread {
        @Override
        public void run() {
            while (System.currentTimeMillis() - START_TIME < 5000) {
                try {
                    orderQueue.poll(10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {e.printStackTrace();}
            }
        }
    }
}
class Order {
    private String pizzaName;
    private long orderTime;
    public Order(String pizzaName) {
        this.orderTime = System.currentTimeMillis();
        this.pizzaName = pizzaName;
    }
}