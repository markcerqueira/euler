package support;

/**
 * Created by Mark on 7/24/16.
 */
public class Pandigital {

    public static boolean isNineDigitPandigital(String string) {
        for (int j = 0; j < string.length(); j++) {
            if (!string.contains("" + (j + 1))) {
                return false;
            }
        }

        return true;
    }
}
