import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
class ConsoleClock extends Thread{

    public String getName1() {
        return super.getName();
    }
    int HH;
    int MM;
    int SS;

    // write class which print time as HH:MM:SS
    // every second here

    public void run() {
        setName("Bong!");
        while (!isInterrupted()) {
            Calendar calendar = Calendar.getInstance();
            HH = calendar.get(Calendar.HOUR_OF_DAY);
            MM = calendar.get(Calendar.MINUTE);
            SS = calendar.get(Calendar.SECOND);
            System.out.printf("%02d:%02d:%02d\n", HH, MM, SS  );
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("The clock was stopped");
                return;
            }
        }
    }

}