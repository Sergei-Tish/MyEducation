import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Time {
    String date = "";

    public void getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss"); // dobavil dlya resheniya
        date = dateFormat.format(calendar.getTime());
        System.out.println(date);
    }
}
