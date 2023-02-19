import java.util.Calendar;

public class Main {

    public static double abs(double num) {
        return num > 0? num : -num;
        // Напишите здесь свой код
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
        // Напишите здесь свой код
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
        // Напишите здесь свой код
    }

    public static void main(String[] args) {
        int a = -6, b = -3;
        int c = Math.abs(a);
        int d = Math.max(a, b);
        int e = Math.min(a, b);
        System.out.println(c + " " + d + " " + e);
        System.out.println(abs(a)  + " " + max(a, b) + " " + min(a, b));


        Calculator calculator = new Calculator();
        calculator.getResult();




    }
}
