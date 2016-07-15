import support.Prime;
import support.Problem;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=3
 */
public class Problem3 extends Problem {

    @Override
    public long solveProblem() {
        long target = 600_851_475_143L;

        //  Larger factors * smaller factors = target
        // Start from 2 and find factors. Then find corresponding (higher) factors
        // and check those for being prime.
        for (long l = 2; l < target; l++) {
            if (target % l == 0) {
                if (Prime.isPrime((target / l))) {
                    return (target / l);
                }
            }
        }

        return -1;
    }
}
