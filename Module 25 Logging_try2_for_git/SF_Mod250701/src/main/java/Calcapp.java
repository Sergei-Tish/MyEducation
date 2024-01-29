import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class Calcapp {
    private static final Scanner sc= new Scanner(System.in);
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Calcapp.class);
    public static void main(String[] args) throws IOException {
        int i = sc.nextInt();
        logger.debug("Entered first num " + i);
        int j = sc.nextInt();
        logger.debug("Entered second num " + j);
        System.out.print("Enter a char: ");
        String k = sc.next();
        logger.debug("Entered char " + k);
        switch (k){
            case "+":
                i=i+j;
                break;
            case "-":
                i=i-j;
                break;
            case "*":
                i=i*j;
                break;
            case "/":
                if (j==0){
                    logger.error("can't divide by zero");
                    i=0;
                }else {
                    i = i / j;
                }
                break;
        }
        logger.debug("result  " + i);
        System.out.println(i);
    }
}