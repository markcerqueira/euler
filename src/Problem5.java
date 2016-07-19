import support.Prime;
import support.Problem;

import java.util.*;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=5
 */
public class Problem5 extends Problem {

    @Override
    public long solveProblem() {
        // To be divisible, we have to find all the prime factors of 1 through 20
        // and then remove duplicates across all those prime duplicates. That will
        // get us the smallest number that is divisible.

        HashMap<Integer, Integer> primeFactorsToOccurrenceMap = new HashMap<>();

        // Initialize here to simplify checking later
        for (int i = 0; i < 20; i++) {
            primeFactorsToOccurrenceMap.put(i, 0);
        }

        for (int i = 20; i > 0; i--) {
            // Get prime factors
            List<Integer> factors = Prime.primeFactors(i);

            // Put the prime factors in a map where the value is the time that prime factor shows up
            HashMap<Integer, Integer> numOccurrences = new HashMap<>();
            for (Integer primeFactor : factors) {
                if (numOccurrences.containsKey(primeFactor)) {
                    numOccurrences.put(primeFactor, numOccurrences.get(primeFactor) + 1);
                } else {
                    numOccurrences.put(primeFactor, 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : numOccurrences.entrySet()) {
                int primeFactor = entry.getKey();

                // We don't simply add the prime factor. We only need the max of the current count of that prime
                // factor and the current count that prime factor shows up.
                int numberOccurrences = Math.max(entry.getValue(), primeFactorsToOccurrenceMap.get(primeFactor));

                primeFactorsToOccurrenceMap.put(primeFactor, numberOccurrences);
            }
        }

        // Now we can calculate the answer by multiplying our prime factors together!
        long solution = 1;
        for (Map.Entry<Integer, Integer> entry : primeFactorsToOccurrenceMap.entrySet()) {
            solution *= Math.pow(entry.getKey(), entry.getValue());
        }

        return solution;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MjMyNzkyNTYw";
    }
}
