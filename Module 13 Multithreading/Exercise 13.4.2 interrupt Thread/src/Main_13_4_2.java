public class Main_13_4_2 {
    public static void main(String[] args) throws InterruptedException { // 4
        Thread threadToInterrupt = new Thread(){
            public void run(){
                while (!isInterrupted()) {
                    System.out.println("Working hard");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //Перехватываем молча
                    System.out.println("фывфыв");
                    interrupt();
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
