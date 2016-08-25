import support.Pandigital;
import support.Permutations;
import support.Prime;
import support.Problem;

import java.util.*;

/**
 * Created by Mark on 7/23/16.
 *
 * https://projecteuler.net/problem=41
 */
public class Problem041 extends Problem {

    @Override
    public long solveProblem() {
        // Start with using all 9 digits and see if there are any primes. If not, we'll use 8 digits, etc.
        for (int i = 9; i > 0; i--) {
            // Generate a sorted list of all pandigital numbers with 1 to i digits
            List<String> candidates = Pandigital.getAllPandigitalPermutations(i, true /* sort */);

            for (String candidate : candidates) {
                if (Prime.isPrime(candidate)) {
                    if (Pandigital.isNineDigitPandigital(candidate)) {
                        return Long.parseLong(candidate);
                    }
                }
            }
        }

        return -1;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NzY1MjQxMw==";
    }
}
