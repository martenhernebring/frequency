package se.hernebring.frequency.engine;

import java.util.LinkedHashSet;
import java.util.Set;

public class LetterFrequency {
    public static String count(String text) {
        Set<Character> unique = new LinkedHashSet<>();
        Set<Character> occurringTwice = new LinkedHashSet<>();
        for(int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if(Character.isLetter(character)) {
                if(unique.contains(character)) {
                    occurringTwice.add(character);
                    unique.remove(character);
                } else {
                    unique.add(character);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        occurringTwice.forEach(letter -> {
            sb.append(letter);
            sb.append(",2");
            sb.append(System.lineSeparator());
        });
        unique.forEach(letter -> {
            sb.append(letter);
            sb.append(",1");
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }
}
