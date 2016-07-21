import support.Factorial;
import support.Problem;

import java.math.BigInteger;

/**
 * Created by Mark on 7/20/16.
 *
 * https://projecteuler.net/problem=25
 */
public class Problem25 extends Problem {

    @Override
    public long solveProblem() {
        BigInteger fibonacci = BigInteger.ONE;
        BigInteger fibonacciPrevious = BigInteger.ONE;

        // We could initialize fibonacciPrevious to null but then we have to null check
        // in the while loop. Instead, initialize to 1 and set index to 2 since we have
        // already calculated the first two Fibonacci numbers.
        long index = 2;

        while (true) {
            if (fibonacci.toString().length() == 1_000) {
                return index;
            }

            BigInteger temp = fibonacci;
            fibonacci = fibonacci.add(fibonacciPrevious);
            fibonacciPrevious = temp;

            index++;
        }
    }

    @Override
    public String base64EncodedAnswer() {
        return "NDc4Mg==";
    }
}
