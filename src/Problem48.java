import support.Problem;

import java.math.BigInteger;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=48
 */
public class Problem48 extends Problem {

    @Override
    public long solveProblem() {
        // Like problem 97 easy (and cheesy) with BigInteger
        BigInteger answer = BigInteger.ONE;

        for (int i = 2; i <= 1000; i++) {
            BigInteger next = BigInteger.valueOf(i);
            answer = answer.add(next.pow(i));
        }

        return Long.parseLong(answer.toString().substring(answer.toString().length() - 10));
    }

    @Override
    public String base64EncodedAnswer() {
        return "OTExMDg0NjcwMA==";
    }
}
