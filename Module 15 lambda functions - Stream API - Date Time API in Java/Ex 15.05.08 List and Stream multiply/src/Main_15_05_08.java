import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main_15_05_08 {
/**
 * Необходимо список строк перевести в список чисел и произвести их умножение.
 * Решите задачу, сначала используя обычный подход, а затем попробуйте написать тот же код на стримах.
 * */

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("2", "3", "4", "5"); // 1*2*3*4*5=120
        main2(stringList); //используя обычный подход

        /* от же код на стримах */
        Optional<String> stringOptional = stringList.stream().reduce((s1, s2) -> String.valueOf(Integer.parseInt(s1) * Integer.parseInt(s2)));
        System.out.println(Integer.parseInt(stringOptional.get()) + " Это значений через stream()");
    }

    public static void main2(List<String> stringList) { //используя обычный подход

        List<Integer> integerList = new ArrayList<>();
        for (String s :
                stringList) {
            integerList.add(Integer.parseInt(s));
        }
        int result = 1;
        for (int integ :
                integerList) {
            result *= integ;
        }

        System.out.println(result + " Это значений через stringList в integerList далее for(each)");
    }
}
