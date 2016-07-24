import support.Prime;
import support.Problem;

/**
 * Created by Mark on 7/22/16.
 *
 * https://projecteuler.net/problem=37
 */
public class Problem037 extends Problem {

    @Override
    public long solveProblem() {
        boolean[] isPrime = new boolean[1_000_001];
        for (int i = 1; i < 1_000_000; i++) {
            isPrime[i] = Prime.isPrime(i);
        }

        long leftRightTruncatablePrimesSum = 0;
        long leftRightTruncatablePrimesFound = 0;

        for (long l = 10; leftRightTruncatablePrimesFound < 11; l++) {
            if (Prime.isPrime(l)) {
                boolean foundNonPrime = false;

                // Check one way
                String str = l + "";
                while (str.length() > 1) {
                    str = str.substring(1);
                    if (!Prime.isPrime(Long.parseLong(str))) {
                        foundNonPrime = true;
                        break;
                    }
                }

                // Check the other way
                str = l + "";
                if (!foundNonPrime) {
                    for (int j = str.length(); j > 0; j--) {
                        if (!Prime.isPrime(str.substring(0, j))) {
                            foundNonPrime = true;
                            break;
                        }
                    }
                }

                if (!foundNonPrime) {
                    leftRightTruncatablePrimesFound++;
                    leftRightTruncatablePrimesSum += l;
                }

            }
        }

        return leftRightTruncatablePrimesSum;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NzQ4MzE3";
    }
}
