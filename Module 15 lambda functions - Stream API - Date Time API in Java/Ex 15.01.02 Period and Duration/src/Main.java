import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Main {
    int anInt = new Integer(0);

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2009, 4, 22);
        Period period = Period.ofYears(4);
        //System.out.println(date.minus(period)); // 2005-4-22
        Period period1 = Period.ofDays(4);
        //System.out.println(date.minus(period1)); // 2005-4-18
        LocalTime time = LocalTime.of(18, 00);
        Duration duration = Duration.ofMinutes(11);
        Duration duration2 = Duration.ofMinutes(32);
        //System.out.println(time.plus(duration));

        Main main = new Main();
        System.out.println(main.localTime1Duration2(time /*12h00m*/,duration /*11*/, duration2 /*32*/));
    }


    /** Задание 15.1.3
     Напишите метод, который будет принимать 2 объекта: 1 типа LocalTime и 2 типа Duration, и будет возвращать true, если переданное время + промежуток больше текущего времени.
     */
    public boolean localTime1Duration2 (LocalTime localTime, Duration duration1, Duration duration2) {
        LocalTime time2Dur = ((localTime.plus(duration1).plus(duration2)));
//        System.out.println(time2Dur);

        LocalTime nowTime = LocalTime.now();
//        System.out.println(nowTime);
        Duration nowHours = Duration.ofHours(nowTime.getHour());
        Duration nowMinutes = Duration.ofMinutes(nowTime.getMinute());
        Duration nowSeconds = Duration.ofSeconds(nowTime.getSecond());

        System.out.println(time2Dur.minus(nowHours));
        System.out.println(time2Dur.minus(nowHours).minus(nowMinutes));
        System.out.println(time2Dur.minus(nowHours).minus(nowMinutes).minus(nowSeconds));
        System.out.println(time2Dur.compareTo(nowTime));
        return time2Dur.compareTo(nowTime) == 1;
    }
}
