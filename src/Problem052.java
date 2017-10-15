import support.Problem;

import java.util.Arrays;

/**
 * Created by Mark on 10/14/17.
 *
 * https://projecteuler.net/problem=52
 */
public class Problem052 extends Problem {

    @Override
    public long solveProblem() {
        for (int i = 1; true; i++) {
            String mostRecentResult = null;
            for (int j = 1; j <= 6; j++) {
                char[] multiplicationDigits = Integer.toString(i * j).toCharArray();
                Arrays.sort(multiplicationDigits);

                if (mostRecentResult == null) {
                    mostRecentResult = new String(multiplicationDigits);
                } else if (!mostRecentResult.equals(new String(multiplicationDigits))) {
                    break;
                } else if (j == 6) {
                    return i;
                }
            }
        }
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTQyODU3";
    }
}
