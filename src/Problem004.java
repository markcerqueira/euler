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
public class Problem004 extends Problem {

    @Override
    public long solveProblem() {
        // Start big and work our way down
        long maxAnswer = 999 * 999;

        for (long l = maxAnswer; l > 0; l--) {
            if (Palindrome.isPalindrome(l)) {
                // Find the largest three-digit factor first
                long largestThreeDigitFactor = -1;
                for (long j = 1000; j >= 100; j--) {
                    if (l % j == 0) {
                        largestThreeDigitFactor = j;
                        break;
                    }
                }

                // Now find the other factor to the largest three-digit factor.
                if (largestThreeDigitFactor != -1) {
                    long otherFactor = l / largestThreeDigitFactor;

                    // Check if that other factor is also three digits and if so we
                    // have our answer!
                    if (otherFactor < 1000 && otherFactor >= 100) {
                        return l;
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public String base64EncodedAnswer() {
        return "OTA2NjA5";
    }
}
