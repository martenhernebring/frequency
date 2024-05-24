package se.hernebring.frequency.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PrinterTest {

    @Test
    void printFile() throws IOException {
        Printer.printLetterFrequencyFromTxtFile();
    }
}
