import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Calcapp {
    private static final Logger log = LogManager.getLogger(Test_log.class);
    private static final Scanner sc = new Scanner(System.in);

    static int i;
    static int j;
    static char k;

    public static void main(String[] args) {
        while (true) {
            String inputString = sc.next();
            if (inputString.matches(".*[^0-9+\\-*/].*")) {
                log.error("Input: \"" + inputString + "\". Введён недопустимый символ! Прекращение работы калькулятора.");
                break;
            }

            String[] strArr = new String[2];
            k = '+';

            if (inputString.contains("+")) {
                strArr = inputString.split("\\+");
                k = '+';
            } else if (inputString.contains("-")) {
                strArr = inputString.split("-");
                k = '-';
            } else if (inputString.contains("*")) {
                strArr = inputString.split("\\*");
                k = '*';
            } else if (inputString.contains("/")) {
                strArr = inputString.split("/");
                k = '/';
            }

            i = Integer.parseInt(strArr[0]);
            j = Integer.parseInt(strArr[1]);

            log.info("Entered first num " + i);
            log.info("Entered char " + k);
            log.info("Entered second num " + j);

            switch (k) {
                case '+':
                    i = i + j;
                    break;
                case '-':
                    i = i - j;
                    break;
                case '*':
                    i = i * j;
                    break;
                case '/':
                    if (j == 0) {
                        log.fatal("can't divide by zero");
                        i = 0;
                    } else {
                        i = i / j;
                    }
                    break;
            }
            log.info("result " + i);
            System.out.println(i);
        }
    }
}
