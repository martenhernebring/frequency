package se.hernebring.frequency.engine;

public class LetterFrequency {
    public static String count(String text) {
        StringBuilder sb = new StringBuilder();
        char previous = 0;
        for(int i = 0; i < text.length(); i++) {
            char letterOrPunctuation = text.charAt(i);
            if(Character.isLetter(letterOrPunctuation)) {
                if(letterOrPunctuation == previous) {
                    sb.replace(sb.length() - 3, sb.length() - 2, "2");
                } else {
                    sb.append(letterOrPunctuation);
                    sb.append(",1");
                    sb.append(System.lineSeparator());
                }
                previous = letterOrPunctuation;
            }
        }
        return sb.toString();
    }
}
