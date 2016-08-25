package support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static List<String> getAllPandigitalPermutations(int digits) {
        return getAllPandigitalPermutations(digits, false /* do not sort by default */, false /* do not include zero by default */);
    }

    public static List<String> getAllPandigitalPermutations(int digits, boolean sort) {
        return getAllPandigitalPermutations(digits, sort, false /* do not include zero by default */);

    }

    public static List<String> getAllPandigitalPermutations(int digits, boolean sort, boolean includeZero) {
        StringBuilder permuteStringBuilder = new StringBuilder();
        for (int i = digits; includeZero ? i >= 0 : i > 0; i--) {
            permuteStringBuilder.append("" + i);
        }

        // Generate permutations
        List<String> candidates = new ArrayList<>();
        Permutations.permutations(permuteStringBuilder.toString(), candidates);

        if (sort) {
            Collections.sort(candidates, (o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1));
        }

        return candidates;
    }
}
