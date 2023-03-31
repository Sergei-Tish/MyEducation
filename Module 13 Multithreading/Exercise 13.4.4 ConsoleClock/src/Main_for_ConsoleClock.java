public class Main_for_ConsoleClock {


    public static void main(String[] args) throws InterruptedException{
        System.out.print(Thread.currentThread().getId() + " ");
        System.out.println(Thread.currentThread().getName());
        ConsoleClock cc = new ConsoleClock();
        cc.start();
        System.out.print(cc.threadId() + " ");
        System.out.println(cc.getName());
        Thread.sleep(3000);
        cc.interrupt();
    }

}