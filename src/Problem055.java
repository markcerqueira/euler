import support.Integers;
import support.Palindrome;
import support.Problem;

import java.math.BigInteger;

/**
 * Created by Mark on 2/3/17.
 *
 * https://projecteuler.net/problem=55
 */
public class Problem055 extends Problem {

    @Override
    public long solveProblem() {
        long lychrelNumberCount = 0;

        for (long i = 1; i < 10_000; i++) {
            BigInteger currentValue = BigInteger.valueOf(i);
            boolean foundPalindrome = false;
            for (int j = 0; j < 50 && !foundPalindrome; j++) {
                if (j > 0 && Palindrome.isPalindrome(currentValue.toString())) {
                    foundPalindrome = true;
                    continue;
                }
                currentValue = currentValue.add(new BigInteger(Integers.reverseNumber(currentValue.toString())));
            }

            if (!foundPalindrome) {
                lychrelNumberCount++;
            }
        }

        return lychrelNumberCount;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MjQ5";
    }
}
