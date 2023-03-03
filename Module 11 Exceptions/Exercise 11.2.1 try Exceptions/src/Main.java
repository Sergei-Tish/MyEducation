import java.text.NumberFormat;

public class Main {
    public static int juice() {return 0;}

    public static void main(String[] args) {
        Main main = new Main();
        String str = "string";
        int one = 1;
        int[] arrInt = new int[3];
        long[] arrLong = new long[3];
        arrLong[0] = -4000000000L;

        System.out.println(main.juice());
        System.out.println(retret.qwerty());
        NumberFormat nf = NumberFormat.getInstance();
        //специально создаем ситуацию, которая приведет к исключению
        System.out.println(nf.parse("NOT A NUMBER"));
/*
You have to throw some runtime exceptions.
Do it here!
*/
    }
}

class retret extends Main {
    public static int qwerty() {
        return retret.qwerty();
    }
    public int qwe() {
        return 0;
    }
}