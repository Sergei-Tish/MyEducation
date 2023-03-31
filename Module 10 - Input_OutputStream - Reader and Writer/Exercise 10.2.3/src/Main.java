import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        /*3*/       File fileName = new File ("Root//files", "asciitable.txt");
        /*4*/       FileInputStream fis = new FileInputStream(fileName);
        int count = 0;
        /*5*/       int i;
        /*6*/       while ((i = fis.read()) != -1) {
            if (
                /*7*/                i == '0' ||
                    /*7*/                i == '1' ||
                    /*7*/                i == '2' ||
                    /*7*/                i == '3' ||
                    /*7*/                i == '4' ||
                    /*7*/                i == '5' ||
                    /*7*/                i == '6' ||
                    /*7*/                i == '7' ||
                    /*7*/                i == '8' ||
                    /*7*/                i == '9'
            ) {count += 1;}
        }
        /*8*/       fis.close();
        /*9*/       System.out.println(count);
    }
}


