import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_15_05_Screencast {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);


        List<Integer> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        Stream<List<Integer>> listStream = Stream.of(list1, list2);

//        listStream.peek(System.out::println)
//                .map(list -> list.stream())
//                .map(i -> i * 2)
//                .collect(Collectors.toList())
//                .peek(System.out::println).forEach(System.out::println);
//
        Stream<List<Integer>> multipliedStream = listStream.map(list -> list.stream()
                .map(i -> i * 2)
                .collect(Collectors.toList()));
        multipliedStream.forEach(System.out::println);
        /**
         * Теперь в multipliedStream каждый список будет содержать элементы, умноженные на 2.
         * */
    }

}
