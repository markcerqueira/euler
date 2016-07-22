import support.Problem;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=32
 */
public class Problem32 extends Problem {

    @Override
    public long solveProblem() {
        Set<Long> productsFound = new HashSet<>();
        long answer = 0;

        // The largest number that can be our product is 987654321. Note this leaves no room for our muplicands so it
        // technically could be lower.
        for (int i = 1; i <= Math.sqrt(987654321); i++) {
            // Because i * j = j * i, we don't need to go all the way up to the max in this inner loop
            for (int j = 1; j <= (Math.sqrt(987654321) / i); j++) {
                long product = i * j;

                String string = "" + product + i + j;

                // Having 1-9 appear once in a string is a 9 digit string so skip anything that isn't this exact length
                if (string.length() != 9) {
                    continue;
                }

                char[] chars = string.toCharArray();
                Arrays.sort(chars);

                boolean isPandigital = true;

                // Our sorted string should be "123456789" if the product is pandigital
                for (int c = 1; c <= 9 && isPandigital == true; c++) {
                    // Since we're excluding 0, we need to do -1 to get indices correct
                    if (chars[c - 1] - '0' != c) {
                        isPandigital = false;
                        break;
                    }
                }

                // productsFound makes sure we don't add the same product to our answer tracker twice
                if (isPandigital && !productsFound.contains(product)) {
                    productsFound.add(product);
                    answer += product;
                }
            }
        }

        return answer;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NDUyMjg=";
    }
}
