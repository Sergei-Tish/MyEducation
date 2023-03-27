public class Main_13_3_2 extends Thread{

    // Lunch the show() method from the class Advertisement
    // (it's hidden) in a new Thread
    public static void main(String[] args){
        Main_13_3_2 main_13_3_2 = new Main_13_3_2();
        main_13_3_2.start();

        ///////////// Задание 13.3.4 ///////
            // Lunch thread on class Advertisement,
            // which implements Runnable
            // (it's hidden)

        new Thread(new Advertisement()).start();
        ////////////////////////////////////



    }
    public void run() {
        Advertisement.show();
    }
}