import java.util.concurrent.atomic.AtomicInteger;

public class BankAtomicInteger extends Thread {
    private AtomicInteger money = new AtomicInteger(10000);

    public BankAtomicInteger() {
        new Client().start();
        new Client().start();
        new Client().start();
    }

    class Client extends Thread{
        @Override
        public void run() {
            while(true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public void take(int moneyOperation) {
        money.addAndGet(-moneyOperation);
    }

    public void repay(int moneyOperation) {
        money.addAndGet(moneyOperation);
    }

    public static void main(String[] args) throws InterruptedException {
        BankAtomicInteger bank = new BankAtomicInteger();
        while (true) {

            sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Bank money: " + bank.money);
        }
    }
}
