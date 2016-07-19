import support.Problem;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 7/19/16.
 *
 * https://projecteuler.net/problem=17
 */
public class Problem17 extends Problem {

    private static Map<String, Integer> stringNumberToLengthMap = new HashMap<>();

    static {
        stringNumberToLengthMap.put("1", "one".length());
        stringNumberToLengthMap.put("2", "two".length());
        stringNumberToLengthMap.put("3", "three".length());
        stringNumberToLengthMap.put("4", "four".length());
        stringNumberToLengthMap.put("5", "five".length());
        stringNumberToLengthMap.put("6", "six".length());
        stringNumberToLengthMap.put("7", "seven".length());
        stringNumberToLengthMap.put("8", "eight".length());
        stringNumberToLengthMap.put("9", "nine".length());
        stringNumberToLengthMap.put("10", "ten".length());
        stringNumberToLengthMap.put("11", "eleven".length());
        stringNumberToLengthMap.put("12", "twelve".length());
        stringNumberToLengthMap.put("13", "thirteen".length());
        stringNumberToLengthMap.put("14", "fourteen".length());
        stringNumberToLengthMap.put("15", "fifteen".length());
        stringNumberToLengthMap.put("16", "sixteen".length());
        stringNumberToLengthMap.put("17", "seventeen".length());
        stringNumberToLengthMap.put("18", "eighteen".length());
        stringNumberToLengthMap.put("19", "nineteen".length());
        stringNumberToLengthMap.put("20", "twenty".length());
        stringNumberToLengthMap.put("30", "thirty".length());
        stringNumberToLengthMap.put("40", "forty".length());
        stringNumberToLengthMap.put("50", "fifty".length());
        stringNumberToLengthMap.put("60", "sixty".length());
        stringNumberToLengthMap.put("70", "seventy".length());
        stringNumberToLengthMap.put("80", "eighty".length());
        stringNumberToLengthMap.put("90", "ninety".length());
    }

    public int onesDigitLength(int i) {
        if (i == 0) {
            return 0;
        } else if (i > 0 && i < 10) {
            return stringNumberToLengthMap.get("" + i);
        } else {
            throw new RuntimeException("Number is not in ones-digit range: " + i);
        }
    }

    public int tensDigitLength(int i) {
        return stringNumberToLengthMap.get("" + i + "0");
    }

    @Override
    public long solveProblem() {
        long totalDigits = 0;

        // Calculate the numbers of digits from 1 to 99
        for (int i = 1; i <= 99; i++) {
            if (i <= 20) {
                totalDigits += stringNumberToLengthMap.get("" + i);
            } else if (i <= 99) {
                int tensDigitValue = i / 10;
                int onesDigitValue = i % 10;

                totalDigits += onesDigitLength(onesDigitValue);
                totalDigits += tensDigitLength(tensDigitValue);
            }
        }

        // 1 to 99 contains 854 digits and occurs ten times in the 1 to 1000 range
        totalDigits *= 10;

        // Account for 100, 200, 300, 400, 500, 600, 700, 800, and 900
        for (int i = 1; i <= 9; i++) {
            totalDigits += onesDigitLength(i) + "hundred".length();
        }

        // Account for the hundreds digit in 101-199, 201-299... 900-999
        // We don't add a space or hyphens because the problem states NOT to count those.
        for (int i = 1; i <= 9; i++) {
            totalDigits += (onesDigitLength(i) + "hundredand".length()) * 99;
        }

        // Finally, add 1000 (again with no spaces)
        totalDigits += "onethousand".length();

        return totalDigits;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MjExMjQ=";
    }
}
