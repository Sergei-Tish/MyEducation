import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;



public class MainMyException {

    public static void main(String[] args) {
        try {
            copyFileUsingStream(new File("src/utf8.txt"), "utf-8", new File("src/win1251.txt"), "windows-1251");
        } catch (ConvertException e) {
            System.out.println(e.getMessage());;
        }
    }

    private static void copyFileUsingStream(File source, String sourceEnc, File dest, String destEnc) throws ConvertException {
        Charset sEnc = null;
        try (Reader fis = new FileReader(source, Charset.forName(sourceEnc));
             Writer fos = new FileWriter(dest, Charset.forName(destEnc))) {
            char[] buffer = new char[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new ConvertException("Проблема со входным/выходным файлом: " + e.getMessage());
        } catch (UnsupportedCharsetException e) {
            throw new ConvertException("Проблема с кодировкой файла: " + e.getMessage());
        } catch (IOException e) {
            throw new ConvertException("Проблема при копировании:" + e.getMessage());
        }

        System.out.println("Перекодировка прошла успешно");
    }
}