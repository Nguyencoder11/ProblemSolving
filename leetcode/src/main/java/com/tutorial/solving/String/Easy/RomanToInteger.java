package com.tutorial.solving.String.Easy;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = romanValues.get(s.charAt(i));

            if (i < n - 1 && currentValue < romanValues.get(s.charAt(i + 1))) {
                ans -= currentValue;
            } else {
                ans += currentValue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();

        String[] testCases = {
                "III", // 3
                "LVIII", // 58
                "MCMXCIV" // 1994
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: s = " + testCases[i]);

            int result = solution.romanToInt(testCases[i]);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
