import support.Permutations;
import support.Prime;
import support.Problem;

import java.util.*;

/**
 * Created by Mark on 2/3/17.
 *
 * https://projecteuler.net/problem=49
 */
public class Problem049 extends Problem {

    @Override
    public long solveProblem() {
        List<Long> primes = Prime.getPrimesBetween(1_000, 10_000);

        Set<Long> permutationPrimes = new HashSet<>();
        for (Long primeNumber : primes) {
            if (permutationPrimes.size() >= 3) {
                // Ignore this one because these are provided in the problem as an example so we don't want to hit them.
                if (!permutationPrimes.contains(1487L)) {
                    List<Long> primesList = new LinkedList<>(permutationPrimes);
                    Collections.sort(primesList);

                    // We may have more than 3 prime permutations so try all combinations of 3
                    for (int a = primesList.size() - 1; a >= 2; a--) {
                        for (int b = a - 1; b >= 1; b--) {
                            for (int c = a - 2; c >= 0; c--) {
                                if (primesList.get(a) - primesList.get(b) == 3330 && primesList.get(b) - primesList.get(c) == 3330) {
                                    return Long.parseLong("" + primesList.get(c) + primesList.get(b) + primesList.get(a));
                                }
                            }
                        }
                    }
                }
            }

            permutationPrimes.clear();
            permutationPrimes.add(primeNumber);

            // Get permutations
            Set<Long> permutations = new LinkedHashSet<>();
            Permutations.numberPermutations(primeNumber, permutations);

            for (Long permutation : permutations) {
                if (Prime.isPrime(permutation)) {
                    // Only allow 4-digit numbers
                    if (("" + permutation).length() == 4) {
                        permutationPrimes.add(permutation);
                    }
                }
            }
        }

        return -1;
    }

    @Override
    public String base64EncodedAnswer() {
        return "Mjk2OTYyOTk5NjI5";
    }
}
