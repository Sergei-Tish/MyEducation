import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
Make byte InputStream OneZeroStream, which gives
1 0 1 0 .....
*/
        Scanner scanner = new Scanner(new OneZeroStream());
        for (int i = 0; i < 10; i++){
            System.out.print(scanner.nextInt());
        }
        System.out.println();

        byte[] bytes = {'0', ' ', '9', ' '};
        int index = 0;
        for (int h = 0; h < 20; h++) {
            if (index >= bytes.length) index = 0;
            System.out.print((char)bytes[index++] + "");
        }

/*
The code above has to output
1010101010
*/
        scanner.close();
    }
}
