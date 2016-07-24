import support.Prime;
import support.Problem;

import java.math.BigInteger;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=26
 */
public class Problem026 extends Problem {

    @Override
    public long solveProblem() {
        long longestRecurringSequenceLength = -1;
        long longestRecurringSequenceNumber = -1;

        for (int i = 2; i < 1000; i++) {
            // Optimization because primes will produce the longest repeating sequences
            // https://en.wikipedia.org/wiki/Repeating_decimal#Fractions_with_prime_denominators
            if (!Prime.isPrime(i)) {
                continue;
            }

            int remainderValue = 10 % i;
            int moduloCounter = 0;

            // Loop until we get a 1 (which means we reach the end of the cycle and the beginning of the next cycle)
            // or our modulo operation count exceeds the number itself.
            while (remainderValue != 1 && moduloCounter < i) {
                remainderValue = remainderValue * 10 % i; // Moving over to the right so multiply by 10
                moduloCounter++;
            }

            if (moduloCounter < i && moduloCounter > longestRecurringSequenceLength) {
                longestRecurringSequenceLength = moduloCounter;
                longestRecurringSequenceNumber = i;
            }
        }

        return longestRecurringSequenceNumber;
    }

    @Override
    public String base64EncodedAnswer() {
        return "OTgz";
    }
}
