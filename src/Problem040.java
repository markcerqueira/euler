import support.Problem;

/**
 * Created by Mark on 7/22/16.
 *
 * https://projecteuler.net/problem=40
 */
public class Problem040 extends Problem {

    @Override
    public long solveProblem() {
        // Use "." so we can do the rest without accounting for 0-index charAt
        StringBuilder irrationalDecimal = new StringBuilder(".");
        for (int i = 1; irrationalDecimal.length() <= 1_000_000; i++) {
            irrationalDecimal.append("" + i);
        }

        long result = 1;
        for (int i = 1; i <= 1_000_000; i *= 10) {
            result *= irrationalDecimal.charAt(i) - '0';
        }

        return result;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MjEw";
    }
}
