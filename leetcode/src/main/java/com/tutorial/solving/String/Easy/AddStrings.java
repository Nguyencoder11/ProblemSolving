package com.tutorial.solving.String.Easy;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            result.append(sum % 10);

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings solution = new AddStrings();

        String[] num1Testcase = {
                "11",
                "456",
                "0"
        };
        String[] num2Testcase = {
                "123",
                "77",
                "0"
        };

        for (int i = 0; i < num1Testcase.length; i++) {
            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: num1 = \"" + num1Testcase[i] + "\", num2 = \"" + num2Testcase[i] + "\"");
            System.out.println("Output: \"" + solution.addStrings(num1Testcase[i], num2Testcase[i]) + "\"");
            System.out.println();
        }
    }
}
