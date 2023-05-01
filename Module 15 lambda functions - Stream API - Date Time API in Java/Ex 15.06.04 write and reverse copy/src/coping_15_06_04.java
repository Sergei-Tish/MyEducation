import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//  K:\Test_for_idea\papka1\fileTest1.txt
public class coping_15_06_04 {
    public static void main(String[] args) throws IOException {


        Path path = Paths.get("K:\\Test_for_idea\\papka1\\fileTest1.txt");
        Path path2 = Paths.get("K:\\Test_for_idea\\papka1\\fileTest2.txt");

//        BufferedReader reader1 = Files.newBufferedReader(path, StandardCharsets.US_ASCII);
//        String currentLine = null;
//        currentLine = reader1.readLine();

        List<String> data = new ArrayList<>();

        try (BufferedReader reader1 = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) { // Выбираем кодировку файла
            String currentLine = null;
            while ((currentLine = reader1.readLine()) != null) {
                data.add(currentLine);
                System.out.println(currentLine);
            }
        }
        String str = "";
        data.sort(Comparator.reverseOrder());

        try (BufferedWriter writer = Files.newBufferedWriter(path2, Charset.defaultCharset(), StandardOpenOption.APPEND)) {  /**, StandardOpenOption.APPEND*/
            for (String s1 :
                    data) {
                writer.write(s1 + "\n");

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

        try (BufferedReader reader2 = Files.newBufferedReader(path2, StandardCharsets.US_ASCII)) { // Выбираем кодировку файла
            // читаем со стрима
            String currentLine2 = null;
            while ((currentLine2 = reader2.readLine()) != null) {
                System.out.println("Строка файл2 " + currentLine2);
            }
        } catch (IOException e) {
            // Handle file I/O exception
        }


    }
}
