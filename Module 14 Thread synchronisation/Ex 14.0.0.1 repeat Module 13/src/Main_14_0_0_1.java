public class Main_14_0_0_1 {
    public static void main(String[] args) throws InterruptedException {
/*  Launch thread LoadingThread here
    and just after it's finish
    print "Images are loaded"           */


        LoadingThread th = new LoadingThread();
        th.start();
        th.interrupt();
        try {
            th.join(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("Images are loaded");

    }

}
