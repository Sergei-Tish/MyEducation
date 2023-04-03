public class Bank extends Thread {
    private int money = 10000;

    public Bank() {
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

    public synchronized void take(int moneyOperation) {
            money -= moneyOperation;
    }

    public synchronized void repay(int moneyOperation) {
        money += moneyOperation;
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {

            sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Bank money: " + bank.money);
        }
    }
}
