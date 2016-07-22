import support.Problem;

import java.math.BigInteger;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=97
 */
public class Problem97 extends Problem {

    @Override
    public long solveProblem() {
        // Find 28433 × (2^7830457) + 1
        // Super easy (and cheesy) with BigInteger
        BigInteger answer = BigInteger.valueOf(2);
        answer = answer.pow(7830457);
        answer = answer.multiply(BigInteger.valueOf(28433));
        answer = answer.add(BigInteger.ONE);

        return Long.parseLong(answer.toString().substring(answer.toString().length() - 10));
    }

    @Override
    public String base64EncodedAnswer() {
        return "ODczOTk5MjU3Nw==";
    }
}
