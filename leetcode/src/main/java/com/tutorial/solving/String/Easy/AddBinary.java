package com.tutorial.solving.String.Easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = digitA + digitB + carry;

            result.append(sum % 2);

            carry = sum / 2;

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();

        String[] StringA_TC = {
                "11",
                "1010"
        };

        String[] StringB_TC = {
                "1",
                "1011"
        };

        for (int i = 0; i < StringA_TC.length; i++) {
            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: a = " + StringA_TC[i] + ", b = " + StringB_TC[i]);

            String result = solution.addBinary(StringA_TC[i], StringB_TC[i]);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
