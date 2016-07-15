import support.Problem;

/**
 * Created by Mark on 7/15/16.
 *
 * https://projecteuler.net/problem=9
 */
public class Problem9 extends Problem {

    @Override
    public long solveProblem() {
        // A bit brute force but it gets the job done in < 200 ms (executing inner for loop about 70k times)
        for (int a = 1; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                for (int c = b; c < 1000; c++) {
                    if (a + b + c == 1000 && a * a + b * b == c * c) {
                        return a * b * c;
                    }
                }
            }
        }

        return -1;
    }
}
