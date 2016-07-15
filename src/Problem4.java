import support.Palindrome;
import support.Prime;
import support.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=4
 */
public class Problem4 extends Problem {

    @Override
    public long solveProblem() {
        // Start big and work our way down
        long maxAnswer = 999 * 999;

        List<Long> palindromes = new ArrayList<>();
        for (long l = maxAnswer; l > 0; l--) {
            if (Palindrome.isPalindrome(l)) {
                palindromes.add(l);
            }
        }

        // palindromes contains a list of candidates with the largest at the front of the list.
        for (long candidatePalindrome : palindromes) {
            // Find the largest three-digit factor first
            long largestThreeDigitFactor = -1;
            for (long l = 1000; l >= 100; l--) {
                if (candidatePalindrome % l == 0) {
                    largestThreeDigitFactor = l;
                    break;
                }
            }

            // Now find the other factor to the largest three-digit factor.
            if (largestThreeDigitFactor != -1) {
                long otherFactor = candidatePalindrome / largestThreeDigitFactor;

                // Check if that other factor is also three digits and if so we
                // have our answer!
                if (otherFactor < 1000 && otherFactor >= 100) {
                    return candidatePalindrome;
                }
            }
        }

        return -1;
    }
}
