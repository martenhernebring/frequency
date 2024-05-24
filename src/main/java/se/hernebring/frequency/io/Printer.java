package se.hernebring.frequency.io;

import org.apache.commons.io.IOUtils;
import se.hernebring.frequency.engine.LetterFrequency;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Printer {

    public static void print(String result, String fileName) {
        Path path = Paths.get(fileName + ".txt");
        try (Writer writer = Files.newBufferedWriter(path, Charset.defaultCharset(),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(result);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void printLetterFrequencyFromTxtFile() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/stringtoolong.txt");
        String stringTooLong = IOUtils.toString(fis, "UTF-8");
        String result = LetterFrequency.count(stringTooLong);
        Printer.print(result, "character_frequency");
    }
}
