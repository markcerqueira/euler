import support.Prime;
import support.Problem;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=7
 */
public class Problem007 extends Problem {

    @Override
    public long solveProblem() {
        int primeCount = 1;

        // Start at 3 (so primeCount is initialized to 1) and increment by 2
        // because even numbers after 2 are not prime.
        for (int i = 3; /* loop infinitely */ ; i += 2) {
            if (Prime.isPrime(i)) {
                if (++primeCount == 10001) {
                    return i;
                }
            }
        }
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTA0NzQz";
    }
}
