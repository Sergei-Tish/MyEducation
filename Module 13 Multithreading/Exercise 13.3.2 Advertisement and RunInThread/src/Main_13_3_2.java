public class Main_13_3_2 extends Thread{

    // Lunch the show() method from the class Advertisement
    // (it's hidden) in a new Thread
    public static void main(String[] args){
        Main_13_3_2 main_13_3_2 = new Main_13_3_2();
        main_13_3_2.start();


    }
    public void run() {
        Advertisement.show();
    }
}