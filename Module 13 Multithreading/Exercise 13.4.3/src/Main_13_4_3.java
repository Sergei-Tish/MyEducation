public class Main_13_4_3 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Thread started");
            sleep(0);
        } catch (InterruptedException exception) {
            System.out.println("Thread interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Main_13_4_3();
        thread.start();
        thread.join();
        thread.interrupt();
    }
}