import support.Problem;

/**
 * Created by Mark on 7/23/16.
 *
 * https://projecteuler.net/problem=31
 */
public class Problem31 extends Problem {

    @Override
    public long solveProblem() {
        long MAX_TOTAL = 200;
        long combinations = 0;

        // For each denomination start at having 0 of it, increment by the value of that denomination, and loop until
        // we hit the desired max. In the innermost for loop, count as a combination if our total is equal to MAX_TOTAL.
        for (int i = 0; i <= MAX_TOTAL; i += 200) {
            for (int j = 0; (i + j) <= MAX_TOTAL; j += 100) {
                for (int k = 0; (i + j + k) <= MAX_TOTAL; k += 50) {
                    for (int m = 0; (i + j + k + m) <= MAX_TOTAL; m += 20) {
                        for (int o = 0; (i + j + k + m + o) <= MAX_TOTAL; o += 10) {
                            for (int p = 0; (i + j + k + m + o + p) <= MAX_TOTAL; p += 5) {
                                for (int q = 0; (i + j + k + m + o + p + q) <= MAX_TOTAL; q += 2) {
                                    for (int r = 0; (i + j + k + m + o + p + q + r) <= MAX_TOTAL; r += 1) {
                                        if (i + j + k + m + o + p + q + r == MAX_TOTAL) {
                                            combinations++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return combinations;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NzM2ODI=";
    }
}
