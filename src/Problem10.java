import support.Prime;
import support.Problem;

/**
 * Created by Mark on 7/15/16.
 *
 * https://projecteuler.net/problem=10
 */
public class Problem10 extends Problem {

    @Override
    public long solveProblem() {
        /* long sum = 0;
        for (int i = 3; i < 2_000_000; i +=2) {
            if (Prime.isPrime(i)) {
                sum += i;
            }
        }
        return sum+2; */

        // Should be more efficient than the brute force solution above
        // but runs in the same amount of time... :/
        long sum = 0;
        int[] numbers = new int[2_000_000];
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                continue;
            }

            if (Prime.isPrime(i)) {
                sum += i;
                for (int j = i; j < numbers.length; j+= j) {
                    numbers[j] = 1;
                }
            }
        }

        return sum;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTQyOTEzODI4OTIy";
    }
}
