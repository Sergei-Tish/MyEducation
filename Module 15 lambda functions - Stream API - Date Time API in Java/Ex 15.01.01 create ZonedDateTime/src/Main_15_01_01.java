import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main_15_01_01 {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds() + "\n");

        ZoneId zoneIdPlus3 = ZoneId.of("GMT+3");
        String timeGMTPlus7 = "GMT+7";
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.now(zoneIdPlus3), LocalTime.now(zoneIdPlus3), zoneIdPlus3);
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of(timeGMTPlus7));
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime2.getZone());
        System.out.println("год: " + zonedDateTime2.getYear());
        System.out.println("День года: " + zonedDateTime2.getDayOfYear());
        System.out.println(zonedDateTime2.getDayOfWeek());
    }
}
