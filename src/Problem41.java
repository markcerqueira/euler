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
public class Problem41 extends Problem {

    @Override
    public long solveProblem() {
        // Start with using all 9 digits and see if there are any primes. If not, we'll use 8 digits, etc.
        for (int i = 9; i > 0; i--) {
            // For i = 9 -> "987654321", for i = 8 -> "87654321", etc.
            String permuteString = "";
            for (int j = i; j > 0; j--) {
                permuteString += "" + j;
            }

            // Generate permutations and sort with highest numbers first so if we find a prime, we return the largest
            // one.
            List<String> candidates = new ArrayList<>();
            Permutations.permutations(permuteString, candidates);
            Collections.sort(candidates, (o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1));

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
