import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_15_05_10 {
    public static void main_origin() {

        /**
         * Задание 15.5.10
         * Перепишите данный код, используя стримы:
         * */
        List<Double> list = Arrays.asList(117d, 12.2d, 66d, 18.5d);
        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");
        List<Double> doubles = new ArrayList<>();
        for (String s : list2) {
            doubles.add(Double.valueOf(s));
        }
        Set<Double> sortedDoubles = new TreeSet<>(Comparator.reverseOrder());
        sortedDoubles.addAll(list);
        sortedDoubles.addAll(doubles);
        for (double d : sortedDoubles) {
            System.out.println(d);
        }
    }

    public static void main(String[] args) {
        main_origin();
        System.out.println();

        List<Double> list1 = Arrays.asList(117d, 12.2d, 66d, 18.5d);
        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");

        Stream<Double> streamDouble = Stream.concat(list1.stream(), list2.stream().map(Double::parseDouble));
        Set<Double> setStream = streamDouble.collect(Collectors.toCollection(() -> new TreeSet<Double>(Comparator.reverseOrder())));
        setStream.forEach(System.out::println);

    }
}