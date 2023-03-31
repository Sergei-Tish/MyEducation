public class Main_13_4_2_experiment {
    public static void main(String[] args) throws InterruptedException { // 4
        Thread threadToInterrupt = new Thread() {
            public void run() {
                System.out.println("Текст до прерывания");
                interrupt();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Прерывание потока");
                    return;
                }
                System.out.println("Текст после прерывания");
            }
        };

        threadToInterrupt.start();
        Thread.currentThread().sleep(2500); // 3
        threadToInterrupt.interrupt();
        threadToInterrupt.join();
        System.out.println("Thread finished");
    }
}
