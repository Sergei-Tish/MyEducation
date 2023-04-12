import java.time.*;
import java.util.Date;

public class Main_15_01_02 {
    int anInt = new Integer(0);

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2009, 4, 22);
        Period period = Period.ofYears(4);
        //System.out.println(localDate.minus(period)); // 2005-4-22
        Period period1 = Period.ofDays(4);
        //System.out.println(localDate.minus(period1)); // 2005-4-18
        LocalTime time = LocalTime.of(18, 00);
        Duration duration = Duration.ofMinutes(11);
        Duration duration2 = Duration.ofMinutes(32);
        //System.out.println(time.plus(duration));

        Main_15_01_02 thisMain = new Main_15_01_02();
        System.out.println(thisMain.method_15_1_3(time /*12h00m*/,duration /*11*/, duration2 /*32*/));
        Date date1 = new Date(2013, 2, 1, 0, 70);
        System.out.println("date1: " + date1);
        LocalTime time1 = thisMain.method_15_1_7(date1);
        System.out.println(time1);
    }


    /** Задание 15.1.3
     Напишите метод, который будет принимать 2 объекта: 1 типа LocalTime и 2 типа Duration, и будет возвращать true, если переданное время + промежуток больше текущего времени.
     */
    public boolean method_15_1_3(LocalTime localTime, Duration duration1, Duration duration2) {
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

    /** Задание 15.1.7
     * Создайте метод, который принимает в качестве аргумента объект java.util.Date и возвращает объект LocalTime, содержащий время переданного объекта в вашем часовом поясе.
     */
    public LocalTime method_15_1_7(Date date) {
        Instant instant = date.toInstant();
        LocalTime localTime = LocalTime.from(instant.atZone(ZoneId.of("UTC+3")));
        return localTime;
    }
}


/**
  * Задание 15.1.4
  * 1/1 point (graded)
  * Что делает данный код?
 */
 /*
  public static void main(String[] args) {
     LocalDate date = LocalDate.of(2026, Month.AUGUST, 13);    // строка 1
     LocalTime time = new LocalTime(16, 15);                   // строка 2
     LocalDateTime dateTime = LocalDateTime.of(date, time);    // строка 3
     System.out.println(dateTime);
  }
  Код не компилируется на строке 3
  Выводит в консоль 2026-08-13T16:15Б
  -> Код не компилируется на строке 2 <-
  Такой конструктор компилируется без ошибок
 */

/**
  * Задание 15.1.6
  * 1/1 point (graded)
  * Что делает данный код?
*/
/*
  public static void main(String[] args) {
     LocalDate date = LocalDate.of(2029, 8, 4);
     Period period = Period.ofDays(3);
     date = date.minus(period); // строка 1
     Duration duration = Duration.ofHours(12);
     LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(8, 0));
     dateTime.plus(duration); // строка 2
     System.out.println(dateTime);
  }
  -> Выводит в консоль 2029-08-01T08:00 <-
  Выводит в консоль 2029-08-04T08:00
  Код не компилируется на строке 1
  Код не компилируется на строке 2
 */