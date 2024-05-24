package se.hernebring.frequency.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterFrequencyTest {

    private String threeCharacterFirstLine = "人之初，性本善。性相近，習相遠。";

    @Test
    void noTextReturnsEmptyString() {
        String noText = "";
        assertDoesNotThrow(() -> LetterFrequency.count(noText));
        assertEquals(0, LetterFrequency.count(noText).length());
    }

    @Test
    void oneLetterReturnsLetterAndOne() {
        String single = String.valueOf(threeCharacterFirstLine.charAt(0));
        assertEquals(1, single.length());
        assertEquals("人,1" + System.lineSeparator(), LetterFrequency.count(single));
    }

    @Test
    void twoDifferentLettersReturnsTwoRowsWithLetterAndOne() {
        String tuple = threeCharacterFirstLine.substring(0, 2);
        assertEquals(2, tuple.length());
        StringBuilder sb = new StringBuilder("人,1");
        sb.append(System.lineSeparator());
        sb.append("之,1");
        sb.append(System.lineSeparator());
        assertEquals(sb.toString(), LetterFrequency.count(tuple));
    }

    @Test
    void punctuationShouldNotBeCounted() {
        String sentence = threeCharacterFirstLine.substring(0, 8);
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

    @Test
    void countAllLettersAndReturnCountInOrderOfHighestCountAndFirstOccurring() {
        String result = "性,2" + System.lineSeparator() +
                "相,2" + System.lineSeparator() +
                "人,1" + System.lineSeparator() +
                "之,1" + System.lineSeparator() +
                "初,1" + System.lineSeparator() +
                "本,1" + System.lineSeparator() +
                "善,1" + System.lineSeparator() +
                "近,1" + System.lineSeparator() +
                "習,1" + System.lineSeparator() +
                "遠,1" + System.lineSeparator();
        assertEquals(result, LetterFrequency.count(threeCharacterFirstLine));
    }

    @Test
    void countFrequenciesFromAtLeastThreeTimes() {
        String threeCharacterSecondLine = "苟不教，性乃遷。教之道，貴以專。";
        String result = "性,3" + System.lineSeparator() +
                "之,2" + System.lineSeparator() +
                "相,2" + System.lineSeparator() +
                "教,2" + System.lineSeparator() +
                "人,1" + System.lineSeparator() +
                "初,1" + System.lineSeparator() +
                "本,1" + System.lineSeparator() +
                "善,1" + System.lineSeparator() +
                "近,1" + System.lineSeparator() +
                "習,1" + System.lineSeparator() +
                "遠,1" + System.lineSeparator() +
                "苟,1" + System.lineSeparator() +
                "不,1" + System.lineSeparator() +
                "乃,1" + System.lineSeparator() +
                "遷,1" + System.lineSeparator() +
                "道,1" + System.lineSeparator() +
                "貴,1" + System.lineSeparator() +
                "以,1" + System.lineSeparator() +
                "專,1" + System.lineSeparator();
        assertEquals(result, LetterFrequency.count(threeCharacterFirstLine + threeCharacterSecondLine));
    }
}
