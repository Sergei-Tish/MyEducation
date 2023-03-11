import java.io.File;

public class Answers {
    public static void main(String[] args) {

        /** Возможный код задания 11.2.1. */

        /** 1. Исключение ArithmeticException
         */
        int x1 = 1 / 0;
        /** 2. Исключение ArrayIndexOutOfBoundsException
         */
        int[] x2 = {1};
        x2[1] = 0;
        /** 3. Исключение ArrayStoreException
         */
        Object x3[] = new String[3];
        x3[0] = new Integer(0);

        /** 4. Исключение ClassCastException
         */
        String x4 = "";
        x4 = (String) (new Object());
        /** 5. Исключение NegativeArraySizeException
         */
        String[] x5 = new String[-1];
        /** 6. Исключение NullPointerException
         */
        File x6 = null;
        System.out.println(x6.length());
        /** 7. Исключение NumberFormatException
         */
        System.out.println(Integer.valueOf("ab"));
        /** 8. Исключение StringIndexOutOfBoundsException
         */
        System.out.println("abc".charAt(3));
    }
}