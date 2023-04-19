import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Optional<String> optionalS = new Main().raffle(new Random().nextInt(1, 6));
        if (optionalS.isEmpty()) {
            System.out.println("Выйгрыша нет. Но в следующий раз обязательно повезёт!");
        } else {
            String str = optionalS.get();
            System.out.println(str);
        }

    }

    public Optional<String> raffle(int guess) throws IllegalStateException {
        if (guess < 1 || guess > 5) throw new IllegalStateException("Guess must be between 1 and 5, now we have " + guess);
        if (new Random().nextInt(1, 6) == guess) {
            return Optional.of("Поздравляем вы выйграли!");
        } else {
            return Optional.empty();
        }
    }


}
