import java.util.stream.Stream;

public class MyStreamTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("w", "o", "l", "f");
        String word = stringStream.reduce("", (b, c) -> b.concat(c));
        System.out.println(word); // wolf
    }
}
