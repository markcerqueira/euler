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
        long sum = 0;
        for (int i = 2; i < 2_000_000; i++) {
            if (Prime.isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
