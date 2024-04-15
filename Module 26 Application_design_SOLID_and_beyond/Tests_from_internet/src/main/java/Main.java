import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
    }


    Main(String fullName) {
        this.fullName = fullName;
    }
    String fullName;
    private String getFullName() {
        return fullName;
    }


    public static void test1() {
        String i = "1";

        inc(i);
        System.out.println(i);
    }
    private static void inc(String s) {
        s = s + "2";
    }

    public static void test2() {
        List<Main> itsList = new ArrayList<>();
        Main main = new Main("s");
        Main main1 = new Main("s1");
        Main main2 = new Main("s2");
        Main main3 = new Main("s3");
        Main main4 = new Main("s4");
        itsList.add(main);
        itsList.add(main1);
        itsList.add(main2);
        itsList.add(main3);
        itsList.add(main4);

        String names = itsList.stream()
                .map(Main::getFullName)
                .collect(Collectors.joining("; "));
        System.out.println("-=" + names + "=-");
    }




}


