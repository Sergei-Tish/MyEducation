import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class Main {

    public static void main(String[] args) {
        copyFileUsingStream( new File("src/utf8.txt"), "utf-8", new File("src/win1251.txt"), "windows-1251");
    }

    private static void copyFileUsingStream(File source, String sourceEnc, File dest, String descEnc) {
        Charset sEnc = null;
        try {
            sEnc = Charset.forName(sourceEnc);
        } catch (UnsupportedCharsetException e) {
            System.out.println("Проблема с кодировкой исходного файла");
            return;
        }
        Charset dEnc = null;
        try {
            dEnc = Charset.forName(descEnc);
        } catch (UnsupportedCharsetException e) {
            System.out.println("Проблема с кодировкой выходного файла");
            return;
        }

        Reader fis = null;
        try {
            fis = new FileReader(source, sEnc);
        } catch (IOException e) {
            System.out.println("Проблема со входным файлом");
            return;
        }
        Writer fos = null;
        try {
            fos = new FileWriter(dest, dEnc);
        } catch (IOException e) {
            System.out.println("Проблема с выходным файлом");
            return;
        }
        char[] buffer = new char[1024];
        int length;

        try {
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("Проблема при копировании");
            return;
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                System.out.println("Проблема при закрытии файлов");
                return;
            }
        }
        System.out.println("Перекодировка прошла успешно");
    }
}