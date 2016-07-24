import support.Prime;
import support.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=46
 */
public class Problem046 extends Problem {

    @Override
    public long solveProblem() {
        List<Long> twiceSquareList = new ArrayList<>();
        for (int i = 1; i < 10_000; i++) {
            twiceSquareList.add((long) (2 * Math.pow(i, 2)));
        }

        List<Long> primeList = new ArrayList<>();
        for (long l = 1; l < 10_000; l++) {
            if (Prime.isPrime(l)) {
                primeList.add(l);
            }
        }

        long greatestPrime = primeList.get(primeList.size() - 1);
        long greatestTwiceSquareNum = twiceSquareList.get(twiceSquareList.size() - 1);

        long l = 1;
        while (true) {
            l++;

            // We only care about odd and composite (non-prime) numbers
            if (l % 2 == 0 || Prime.isPrime(l)) {
                continue;
            }


            // If we hit this case we may be missing the answer because we don't have enough numbers. We could expand
            // our lists to make this answer more flexible, but we'll just initialize the lists to a safe size instead.
            if (1 + greatestPrime < l || 1 + greatestTwiceSquareNum < l) {
                throw new RuntimeException("Lists are too small so answer may be incorrect!");
            }

            boolean foundSolution = false;
            for (long prime : primeList) {
                if (twiceSquareList.contains(l - prime)) {
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
               return l;
            }
        }
    }

    @Override
    public String base64EncodedAnswer() {
        return "NTc3Nw==";
    }
}
