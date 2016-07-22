import support.Prime;
import support.Problem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=35
 */
public class Problem35 extends Problem {

    // Returns rotations of integer
    private Set<Integer> rotateInteger(int i) {
        Set<Integer> rotations = new HashSet<>();

        String start = i + "";
        while (true) {
            char replaced = start.charAt(0);
            start = start.replaceFirst(replaced + "", "") + replaced;

            int intValue = Integer.parseInt(start);
            if (rotations.contains(intValue)) {
                break;
            }

            rotations.add(intValue);
        }

        return rotations;
    }

    @Override
    public long solveProblem() {
        Set<Integer> circularPrimes = new HashSet<>();

        // 1,000,001 because we'll ignore the 0th index
        boolean[] isPrime = new boolean[1_000_001];
        for (int i = 1; i < 1_000_000; i++) {
            isPrime[i] = Prime.isPrime(i);
        }

        for (int i = 1; i < 1_000_000; i++) {
            // Special-case single digit numbers
            if (i < 10) {
                if (isPrime[i]) {
                    circularPrimes.add(i);
                }
                continue;
            }

            // If i is already not prime no need to check anything further
            if (!isPrime[i]) {
                continue;
            }

            if (circularPrimes.contains(i)) {
                continue;
            }

            Set<Integer> permutations = rotateInteger(i);

            boolean allPermutationsArePrime = true;
            for (int permutation : permutations) {
                if (!isPrime[permutation]) {
                    allPermutationsArePrime = false;
                    break;
                }
            }

            if (allPermutationsArePrime) {
                circularPrimes.addAll(permutations);
            }
        }

        return circularPrimes.size();
    }

    @Override
    public String base64EncodedAnswer() {
        return "NTU=";
    }
}
