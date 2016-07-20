import support.Factors;
import support.Problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mark on 7/20/16.
 *
 * https://projecteuler.net/problem=21
 */
public class Problem21 extends Problem {

    @Override
    public long solveProblem() {
        Map<Integer, Integer> divisorsSumMap = new HashMap<>();

        for (int i = 1; i <= 10_000; i++) {
            // Get factors (divisors if we exclude the number itself) and sum them up
            List<Integer> factors = Factors.getFactors(i);
            int factorsSum = 0;
            for (Integer factor : factors) {
                // Do not include the number itself.
                if (factor != i) {
                    factorsSum += factor;
                }
            }

            divisorsSumMap.put(i, factorsSum);
        }

        int sumAmicableNumbers = 0;
        for (int i = 1; i <= 10_000; i++) {
            int divisorsSum = divisorsSumMap.get(i);

            // If the sum of divisors equals the number itself it is not an amicable number. It's just a lonely number.
            // FYI the numbers in this range (1 - 10_000) that hit this case are: 6, 28, 496, 8128
            if (divisorsSum == i) {
                continue;
            }

            // If our divisors sum is in divisorsSumMap (this will be true for any divisors sum that is <= 10_000)
            if (divisorsSumMap.containsKey(divisorsSum)) {
                // If our map contains the divisor sum it is an amicable number
                if (divisorsSumMap.get(divisorsSum) == i) {
                    sumAmicableNumbers += i;
                }
            }
        }

        return sumAmicableNumbers;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MzE2MjY=";
    }
}
