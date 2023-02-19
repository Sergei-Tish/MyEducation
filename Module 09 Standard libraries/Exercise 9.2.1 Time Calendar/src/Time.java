import java.awt.im.InputContext;
import java.util.Calendar;
import java.util.TimeZone;

public class Time {
    int millis = 999;
    public void getTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Russia/Moscow"));
        calendar.setTimeInMillis(millis);
        calendar.setTimeInMillis(1000L);  // eto reshenie
        System.out.println(calendar.getTime());
    }
}
// we have Thu Jan 01 07:00:00 NOVT 1970
// me need Thu Jan 01 00:00:01 UTC 1970