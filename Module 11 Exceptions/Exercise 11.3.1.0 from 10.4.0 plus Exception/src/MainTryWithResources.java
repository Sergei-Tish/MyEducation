
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class MainTryWithResources {

    public static void main(String[] args) {
        copyFileUsingStream(new File("src/utf8.txt"), "utf-8", new File("src/win1251.txt"), "windows-1251");
    }

    private static void copyFileUsingStream(File source, String sourceEnc, File dest, String destEnc) {
        Charset sEnc = null;
        try (Reader fis = new FileReader(source, Charset.forName(sourceEnc));
             Writer fos = new FileWriter(dest, Charset.forName(destEnc))) {
            char[] buffer = new char[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Проблема со входным/выходным файлом: " + e.getMessage());
            return;
        } catch (UnsupportedCharsetException e) {
            System.out.println("Проблема с кодировкой исходного/исходного файла: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Проблема при копировании:" + e.getMessage());
            return;
        }
        System.out.println("Перекодировка прошла успешно");
    }
}