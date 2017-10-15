import support.Problem;

import java.math.BigInteger;

/**
 * Created by Mark on 10/14/17.
 *
 * https://projecteuler.net/problem=56
 */
public class Problem056 extends Problem {

    @Override
    public long solveProblem() {
        int maxDigitalSum = -1;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                char[] result = BigInteger.valueOf(a).pow(b).toString().toCharArray();

                int digitalSum = 0;
                for (int i = 0; i < result.length; i++) {
                    digitalSum += (result[i] - '0');
                }

                if (digitalSum > maxDigitalSum) {
                    maxDigitalSum = digitalSum;
                }
            }
        }

        return maxDigitalSum;
    }

    @Override
    public String base64EncodedAnswer() {
        return "OTcy";
    }
}
