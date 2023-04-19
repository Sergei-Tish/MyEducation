import java.util.Optional;

public class Main_15_04_00_1 {
    public static void main(String[] args) {
        Optional<Double> average = average(1);
        System.out.println(average.orElse(Double.NaN));
        System.out.println(average.orElseGet(Math::random));
        System.out.println(average.orElseThrow(IllegalStateException::new));

        String s1 = "s1";
        String s2 = String.copyValueOf(s1.toCharArray());
        System.out.println(s1 + " " + s2);
        s1 = "22";
        System.out.println(s1 + " " + s2);

    }

    private static Optional<Double> average(int... ints) {
        if (ints.length == 0) return Optional.empty();
        double sum = 0;
        for (int i :
                ints) {
            sum += i;
        }
        return Optional.of(sum / ints.length);
    }
}
