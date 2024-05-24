package se.hernebring.frequency.engine;

import java.util.*;

public class LetterFrequency {
    public static String count(String text) {
        Map<Character, Integer> letterFrequency = mapAllCharactersByFrequency(text);
        return createCsvSortedByValueAndOrderDescending(letterFrequency);
    }

    private static Map<Character, Integer> mapAllCharactersByFrequency(String text) {
        Map<Character, Integer> letterFrequency = new LinkedHashMap<>();
        for(int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if(Character.isLetter(character)) {
                if(letterFrequency.containsKey(character)) {
                    int updatedFrequency = letterFrequency.get(character) + 1;
                    letterFrequency.put(character, updatedFrequency);
                } else {
                    letterFrequency.put(character, 1);
                }
            }
        }
        return letterFrequency;
    }

    private static String createCsvSortedByValueAndOrderDescending(Map<Character, Integer> letterFrequency) {
        StringBuilder sb = new StringBuilder();
        letterFrequency.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    sb.append(entry.getKey());
                    sb.append(",");
                    sb.append(entry.getValue());
                    sb.append(System.lineSeparator());
                });
        return sb.toString();
    }
}
