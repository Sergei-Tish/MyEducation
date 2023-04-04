public class DeadlockEdit implements Runnable {

    /**
     * Перепишите код так, чтобы убрать возможный deadlock:
     */
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadlockEdit deadlockEdit1 = new DeadlockEdit();
        DeadlockEdit deadlockEdit2 = new DeadlockEdit();
        new Thread(deadlockEdit1).start();
        new Thread(deadlockEdit2).start();
    }

    @Override
    public void run() {
        doTask1();
        doTask2();
    }

    private void doTask1() {
        synchronized (lock1) {
            System.out.println("Doing task 1");
        }

    }

    private void doTask2() {
        synchronized (lock2) {
            System.out.println("Doing task 2");
        }
    }
}