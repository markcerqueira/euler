import support.Factorial;
import support.Factors;
import support.Problem;

import java.util.*;

/**
 * Created by Mark on 7/20/16.
 *
 * https://projecteuler.net/problem=24
 */
public class Problem024 extends Problem {

    @Override
    public long solveProblem() {
        // We could generate all permutations of "0123456789" but let's be a little more elegant!

        // The plan is to "lock" numbers in and see how many permutations would be eliminated by doing so. For each
        // digit we will go as close to 1_000_000 as possible and then lock that digit in. Rinse and repeat.
        int TARGET = 1_000_000;

        int permutationsEliminated = 0;

        StringBuilder answer = new StringBuilder();

        String numbers = "0123456789";

        // If we "lock" a number in a position, we'll have the rest of the length of that String permutations available.
        // For example, if we assume 0 is fixed at position 0, we only have 362_880 permutations for the remaining 9 numbers.
        long factorialFactor = Factorial.factorial(numbers.length() - 1);

        for (int i = 0; i < numbers.length(); i++) {
            // This branch happens when locking in that digit keeps us below the target
            if (permutationsEliminated + factorialFactor < TARGET) {
                permutationsEliminated += factorialFactor;
            } else {
                // Locking in this digit would result in going over 1_000_000 target so fix it now and move on to the next digit.
                answer.append(numbers.charAt(i));

                // We've used this digit so remove it from the numbers String
                numbers = numbers.replace("" + numbers.charAt(i), "");

                // Since the numbers String has changed length, recalculate our factorialFactor
                factorialFactor = Factorial.factorial(numbers.length() - 1);

                // Reset to -1 because we'll ++ in the for loop to 0
                i = -1;
            }
        }

        return Long.parseLong(answer.toString());
    }

    @Override
    public String base64EncodedAnswer() {
        return "Mjc4MzkxNTQ2MA==";
    }
}
