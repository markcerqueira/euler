import support.Problem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 7/19/16.
 *
 * https://projecteuler.net/problem=20
 */
public class Problem020 extends Problem {

    @Override
    public long solveProblem() throws Exception {
        BigInteger bigInteger = BigInteger.valueOf(1);

        // Calculate 100!
        for (int i = 1; i <= 100; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        String oneHundredFactorial = bigInteger.toString();

        int sumOfDigits = 0;
        for (int i = 0; i < oneHundredFactorial.length(); i++) {
            sumOfDigits += oneHundredFactorial.charAt(i) - '0';
        }

        return sumOfDigits;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NjQ4";
    }
}
