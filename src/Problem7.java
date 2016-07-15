import support.Prime;
import support.Problem;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=7
 */
public class Problem7 extends Problem {

    @Override
    public long solveProblem() {
        int primeCount = 0;
        for (int i = 2; ; i++) {
            if (Prime.isPrime(i)) {
                if (++primeCount == 10001) {
                    return i;
                }
            }
        }
    }
}
