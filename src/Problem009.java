import support.Problem;

/**
 * Created by Mark on 7/15/16.
 *
 * https://projecteuler.net/problem=9
 */
public class Problem009 extends Problem {

    @Override
    public long solveProblem() {
        // A bit brute force but it gets the job done in < 10 ms (inner loop executes ~85k times)
        for (int a = 100; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                int c = 1000 - a - b;
                if (a * a + b * b == c * c) {
                    return a * b * c;
                }
            }
        }

        return -1;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MzE4NzUwMDA=";
    }
}
