import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        OutputStream fos = new FileOutputStream("Module 10.3.1 request.txt");
        fos.write("GIVE ME THE CODE, PLEASE".getBytes());
        fos.close();



/*
Create file request.txt from folder "files" and write phrase
GIVE ME THE CODE, PLEASE
there
*/
    }
}
