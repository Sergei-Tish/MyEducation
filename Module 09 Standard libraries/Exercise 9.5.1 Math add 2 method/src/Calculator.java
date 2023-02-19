import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Calculator {
    double result = 5;
    public void getResult() {
        result = Math.pow(result, 2); // ranee bylo - result = Math.writeMethod(result, 2);
        result = result + 25;
        result = result / 3;
        result = Math.round(result);  // ranee bylo - result = Math.writeMethod(result);
        System.out.println(result);
    }
}
