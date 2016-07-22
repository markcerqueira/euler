import support.Prime;
import support.Problem;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=27
 */
public class Problem27 extends Problem {

    @Override
    public long solveProblem() {
        long longestPrimeLength = 0;
        long longestPrimePairProduct = 0;

        for (int a = -1000; a <= 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                for (int n = 0; true; n++) {
                    if (Prime.isPrime((long)(Math.pow(n, 2) + a * n + b))) {
                        continue;
                    }

                    if (n > longestPrimeLength) {
                        longestPrimeLength = n;
                        longestPrimePairProduct = a * b;
                    }

                    break;
                }
            }
        }

        return longestPrimePairProduct;
    }

    @Override
    public String base64EncodedAnswer() {
        return "LTU5MjMx";
    }
}
