import java.text.NumberFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {


        try {
            NumberFormat nf = NumberFormat.getInstance();
            //специально создаем ситуацию, которая приведет к исключению
            System.out.println(nf.parse("NOT Aaa1 NUMBER"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Конец программы!");

        String string = "123";
        try {
            char chr = string.charAt(10);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        System.out.println("Конец программы!");

        try {
            int a = (int)(Math.random() * 2);
            System.out.println("a = " + a);
            int c[] = { 1/a }; // опасное место #1
            c[a] = 71; // опасное место #2
        } catch(ArithmeticException e) {
            System.err.println("деление на 0" + e);
            e.printStackTrace();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("out of bound: " + e);
        } // окончание try-catch блока
        System.out.println("after try-catch");
    }
}
