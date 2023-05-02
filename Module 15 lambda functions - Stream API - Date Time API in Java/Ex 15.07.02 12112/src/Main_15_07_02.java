import java.util.OptionalLong;
import java.util.stream.Stream;

public class Main_15_07_02 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));
        method();
    }

    static void method() {

        OptionalLong optionalLong = OptionalLong.of(1);
//        System.out.println(optionalLong.getAsLong());
        optionalLong.ifPresent(System.out::println);

        Stream<String> s = Stream.generate(() -> "meow");
        boolean match = s.allMatch(String::isEmpty);
        System.out.println(match);

    }

}
