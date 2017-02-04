package support;

/**
 * Created by Mark on 7/24/16.
 */
public class Integers {

    public static boolean isIntegral(double d) {
        return (int) d == d;
    }

    public static String reverseNumber(String num) {
        StringBuilder reversed = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            reversed.append(num.charAt(i));
        }
        return reversed.toString();
    }
}
