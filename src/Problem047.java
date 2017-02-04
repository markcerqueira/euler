import support.Prime;
import support.Problem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mark on 2/3/17.
 *
 * https://projecteuler.net/problem=47
 */
public class Problem047 extends Problem {

    @Override
    public long solveProblem() {
        // Lowest number that has four distinct prime factors
        int startingNumber = 2 * 3 * 5 * 7;
        while (true) {
            if (hasFourDistinctPrimeFactors(startingNumber)) {
                if (hasFourDistinctPrimeFactors(startingNumber + 1)) {
                    if (hasFourDistinctPrimeFactors(startingNumber + 2)) {
                        if (hasFourDistinctPrimeFactors(startingNumber + 3)) {
                            return startingNumber;
                        }
                    }
                }
            }

            startingNumber++;
        }
    }

    private boolean hasFourDistinctPrimeFactors(int number) {
        List<Integer> factors = Prime.primeFactors(number);
        Set<Integer> factorsSet = new HashSet<>(factors);

        if (factorsSet.size() < 4) {
            return false;
        }

        for (int factor : factors) {
            if (!Prime.isPrime(factor)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTM0MDQz";
    }
}
