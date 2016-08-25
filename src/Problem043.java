import support.Pandigital;
import support.Problem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=
 */
public class Problem043 extends Problem {

    @Override
    public long solveProblem() {
        long sum = 0;

        int[] divisors = {-1, -1, 2, 3, 5, 7, 11, 13, 17};

        List<String> candidates = Pandigital.getAllPandigitalPermutations(9, false /* no sort */, true /* include zero */);
        for (String candidate : candidates) {
            boolean isDivisibleByAll = true;
            for (int i = 2; isDivisibleByAll && i <= 8; i++) {
                if (!isDivisible(candidate, i, divisors[i])) {
                    isDivisibleByAll = false;
                }
            }

            if (isDivisibleByAll) {
                sum += Long.parseLong(candidate);
            }
        }


        return sum;
    }

    private boolean isDivisible(String number, int index, int divisor) {
        long l = Long.parseLong("" + number.charAt(index - 1) + number.charAt(index) + number.charAt(index + 1));
        return l % divisor == 0;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTY2OTUzMzQ4OTA=";
    }
}
