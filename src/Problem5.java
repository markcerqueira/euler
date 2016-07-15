import support.Palindrome;
import support.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=5
 */
public class Problem5 extends Problem {

    @Override
    public long solveProblem() {
        // If divisible by 20, it's divisible by 10 and so on
        // 20 -> 10
        // 19
        // 18 -> 9 -> 3
        // 17
        // 16 -> 8 -> 4 -> 2
        // 15 -> 5
        // 14 -> 7
        // 13
        // 12 -> 6
        // 11
        // 10 -> 5

        // Construct the divisors we check against using the first numbers from the information above.
        int[] divisors = new int[] { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10 };

        // We could also start at 2520 since we are given that information in the problem but it doesn't
        // save us much.
        for (int i = 1; ; i++) {
            boolean noDivisorsFailed = true;
            for (int j = 0; j < divisors.length; j++) {
                if (i % divisors[j] != 0) {
                    noDivisorsFailed = false;
                    break;
                }
            }
            if (noDivisorsFailed) {
                return i;
            }
        }
    }
}
