import support.Problem;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=29
 */
public class Problem29 extends Problem {

    @Override
    public long solveProblem() {
        Set<String> results = new HashSet<>();

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                BigInteger result = BigInteger.valueOf(a);
                result = result.pow(b);
                results.add(result.toString());
            }
        }

        return results.size();
    }

    @Override
    public String base64EncodedAnswer() {
        return "OTE4Mw==";
    }
}
