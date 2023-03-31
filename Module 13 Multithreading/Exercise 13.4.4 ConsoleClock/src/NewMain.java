public class NewMain {
    public static void main(String[] args) throws Exception {
/*  Launch thread LoadingThread here
    and just after it's finish
    print "Images are loaded"*/

        ConsoleClock th = new ConsoleClock();
        th.start();
        th.interrupt();
        th.join(2000);
        System.out.println("Images are loaded");
    }

}