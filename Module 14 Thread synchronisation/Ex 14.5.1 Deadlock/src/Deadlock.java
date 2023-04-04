public class Deadlock implements Runnable {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Deadlock deadlock1 = new Deadlock();
        Deadlock deadlock2 = new Deadlock();
        new Thread(deadlock1).start();
        new Thread(deadlock2).start();
    }

    @Override
    public void run() {
        doTask1();
        doTask2();
    }

    private void doTask1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("Doing task 1");
            }
        }
    }

    private void doTask2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("Doing task 2");
            }
        }
    }
}