import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CalcApp {
    private static final Logger log = LogManager.getLogger(Test_log.class);
    private static final Scanner sc = new Scanner(System.in);

    static int i;
    static int j;
    static char k;

    public static void main(String[] args) {
        CalcApp calcApp = new CalcApp();
        while (true) {
            String inputString = sc.nextLine();
            if (calcApp.hasEndCommand(inputString)) break;
            if (calcApp.hasWrongSymbol(inputString)) continue;
            if (!calcApp.hasDecimalSymbol(inputString)) continue;

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

            if (calcApp.hasFirstDecimalInArray(strArr, inputString))
                i = Integer.parseInt(strArr[0]); // если есть первое число
            else continue; // Прекращение работы если нет первого числа

            if (calcApp.hasSecondDecimalInArray(strArr, inputString))
                j = Integer.parseInt(strArr[1]); // если есть второе число
            else continue; // Прекращение работы если нет второго числа

            log.info("Entered first num \"" + i + "\" and \"" + k + "\" and second num \"" + j + "\" ");

            if (k == '+') {
                i = calcApp.getAdd(i, j);
            } else if (k == '-') {
                i = calcApp.getSubtract(i, j);
            } else if (k == '*') {
                i = calcApp.getMultiply(i, j);
            } else if (k == '/') {
                if (j == 0) {
                    log.fatal("Нельзя делить на ноль");
                    i = 0;
                } else {
                    i = calcApp.getDivide(i, j);
                }
            }
            log.info("result " + i);
            System.out.println(i);
        }
    }

    boolean hasEndCommand(String inputString) {
        if (inputString.contains("end")) {
            log.fatal("Input: \"" + inputString + "\". Команда выключения! Прекращение работы калькулятора.");
            return true;
        }
        return false;
    }

    boolean hasWrongSymbol(String inputString) {
        if (inputString.matches(".*[^0-9+\\-*/].*")) {
            log.error("Input: \"" + inputString + "\". Введён недопустимый символ!");
            return true;
        }
        return false;
    }

    boolean hasDecimalSymbol(String inputString) {
        if (inputString.matches(".*\\d.*")) {
            return true;
        } else {
            log.error("Input: \"" + inputString + "\". При вводе отсутствует число!");
            return false;
        }
    }

    boolean hasFirstDecimalInArray(String[] strArr, String inputString) {
        if (strArr.length > 0 && strArr[0] != null && !strArr[0].isEmpty() && new CalcApp().hasDecimalSymbol((strArr[0]))) {
            return true;
        } else {
            log.error("Input: \"" + inputString + "\". При вводе отсутствует первое число!");
            return false;
        }
    }

    boolean hasSecondDecimalInArray(String[] strArr, String inputString) {
        if (strArr.length > 1 && strArr[1] != null && !strArr[1].isEmpty() && new CalcApp().hasDecimalSymbol((strArr[1]))) {
            return true;
        } else {
            log.error("Input: \"" + inputString + "\". При вводе отсутствует второе число!");
            return false;
        }
    }

    int getAdd(int i, int j) {
        return i + j;
    }

    int getSubtract(int i, int j) {
        return i - j;
    }

    int getMultiply(int i, int j) {
        return i * j;
    }

    int getDivide(int i, int j) {
        return j == 0 ? i : i / j;
    }

}
