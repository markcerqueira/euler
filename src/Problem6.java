import support.Problem;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=6
 */
public class Problem6 extends Problem {

    @Override
    public long solveProblem() {
        // Brute force solution
        /* long sum = 0;
        long powerSum = 0;
        for (int i = 1; i <= 100; i++) {
            powerSum += i * i;
            sum += i;
        }
        return sum * sum - powerSum; */

        long solution = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i == j) {
                    continue;
                }
                solution += (i * j);
            }
        }
        return solution;
    }
}
