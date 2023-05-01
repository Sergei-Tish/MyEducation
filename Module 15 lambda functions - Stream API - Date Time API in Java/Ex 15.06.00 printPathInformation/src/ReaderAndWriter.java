import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
//  K:\Test_for_idea\papka1\fileTest1.txt
public class ReaderAndWriter {
    public static void main(String[] args) {

        Path path2 = Paths.get("K:\\Test_for_idea\\papka1\\fileTest1.txt");
        List<String> data = new ArrayList<>();
        try (BufferedWriter writer = Files.newBufferedWriter(path2, Charset.defaultCharset(), StandardOpenOption.APPEND)) {  /**, StandardOpenOption.APPEND*/
            writer.write("Hello World ");
        } catch (IOException e) {
            // Handle file I/O exception
        }


        Path path = Paths.get("K:\\Test_for_idea\\papka1\\fileTest1.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) { // Выбираем кодировку файла
            // читаем со стрима
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            // Handle file I/O exception
        }



    }
}
