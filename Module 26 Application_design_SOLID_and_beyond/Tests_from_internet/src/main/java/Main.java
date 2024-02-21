public class Main {
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        String i = "1";
        inc(i);
        System.out.println(i);
    }

    private static void inc(String s) {
        s = s + "2";
    }


}


