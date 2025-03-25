package com.tutorial.solving.String.Easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!charToWord.containsKey(c)) {
                charToWord.put(c, word);
            }

            if (!wordToChar.containsKey(word)) {
                wordToChar.put(word, c);
            }

            if (!charToWord.get(c).equals(word) || !wordToChar.get(word).equals(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern solution = new WordPattern();

        String[] patternTC = {
                "abba",
                "abba",
                "aaaa"
        };

        String[] stringTC = {
                "dog cat cat dog",
                "dog cat cat fish",
                "dog cat cat dog"
        };

        for (int i = 0; i < patternTC.length; i++) {
            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: pattern = " + patternTC[i] + ", s = " + stringTC[i]);

            boolean result = solution.wordPattern(patternTC[i], stringTC[i]);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
