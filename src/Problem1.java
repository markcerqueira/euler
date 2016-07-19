import support.Problem;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=1
 */
public class Problem1 extends Problem {

    @Override
    public long solveProblem() {
        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MjMzMTY4";
    }
}
