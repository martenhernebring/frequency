package se.hernebring.frequency.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterFrequencyTest {

    @Test
    void noTextReturnsEmptyString() {
        String noText = "";
        assertDoesNotThrow(() -> LetterFrequency.count(noText));
        assertEquals(0, LetterFrequency.count(noText).length());
    }

    @Test
    void oneLetterReturnsLetterAndOne() {
        String single = "人";
        assertEquals(1, single.length());
        assertEquals("人,1" + System.lineSeparator(), LetterFrequency.count(single));
    }

    @Test
    void twoDifferentLettersReturnsTwoRowsWithLetterAndOne() {
        String tuple = "人之";
        assertEquals(2, tuple.length());
        StringBuilder sb = new StringBuilder("人,1");
        sb.append(System.lineSeparator());
        sb.append("之,1");
        sb.append(System.lineSeparator());
        assertEquals(sb.toString(), LetterFrequency.count(tuple));
    }

    @Test
    void punctuationShouldNotBeCounted() {
        String sentence = "人之初，性本善。";
        String result = "人,1" + System.lineSeparator() +
                    "之,1" + System.lineSeparator() +
                    "初,1" + System.lineSeparator() +
                    "性,1" + System.lineSeparator() +
                    "本,1" + System.lineSeparator() +
                    "善,1" + System.lineSeparator();
        assertEquals(result, LetterFrequency.count(sentence));
    }

    @Test
    void notUniqueLetterShouldBeAddedToCount() {
        String repeatedLetter = "性性";
        String result = "性,2" + System.lineSeparator();
        assertEquals(result, LetterFrequency.count(repeatedLetter));
    }
}
