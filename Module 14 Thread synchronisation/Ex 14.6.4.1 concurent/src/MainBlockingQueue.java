import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MainBlockingQueue {
    public static void main(String[] args) {


        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS); // добавление с ожиданием доступного места (если очередь фиксированной длины)
            blockingQueue.offer(40);

            System.out.println(blockingQueue.poll(100, TimeUnit.MILLISECONDS)); // удаление с ожиданием пока требуемый элемент не станет доступным

            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS)); // удаление с ожиданием пока требуемый элемент не станет доступным

        } catch (InterruptedException exception) {
            // обработка прерывания
        }
    }
}
