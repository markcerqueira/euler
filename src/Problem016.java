import support.Problem;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 7/19/16.
 *
 * https://projecteuler.net/problem=16
 */
public class Problem016 extends Problem {

    @Override
    public long solveProblem() {
        // Brute force but this gets the answer in under 10 ms.
        // A more elegant solution would be like Problem008 where you manually
        // do each multiplication and carry the extra to the next calculation.
        BigInteger bigInteger = BigInteger.valueOf(2);
        for (int i = 1; i < 1000; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(2));
        }

        // This string contains the answer of 2^1000
        String result = bigInteger.toString();

        long answer = 0;
        for (int i = 0; i < result.length(); i++) {
            answer += result.charAt(i) - '0';
        }

        return answer;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTM2Ng==";
    }
}
