import support.Problem;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=6
 */
public class Problem6 extends Problem {

    @Override
    public long solveProblem() {
        long sum = 0;
        long powerSum = 0;
        for (int i = 1; i <= 100; i++) {
            powerSum += i * i;
            sum += i;
        }

        return sum * sum - powerSum;
    }
}
