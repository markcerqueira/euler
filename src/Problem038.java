import support.Pandigital;
import support.Problem;

/**
 * Created by Mark on 7/23/16.
 *
 * https://projecteuler.net/problem=38
 */
public class Problem038 extends Problem {

    @Override
    public long solveProblem() {
        long max = 0;

        // Why up to 98765? n * 1 + n * 2 = 98765 + 197530 = 11 digit number when concatenating so it's a good upper bound
        for (long l = 2; l < 98765; l++) {
            String concatenationOfProducts = "";

            for (int i = 1; true; i++) {
                concatenationOfProducts += "" + (l * i);

                // If our length is over 9 characters we can stop now as we're not pandigital
                if (concatenationOfProducts.length() > 9) {
                    break;
                }

                // If we're not 9 characters long or i < 2 we shouldn't check for pandigital
                if (concatenationOfProducts.length() != 9 || i == 1) {
                    continue;
                }

                if (Pandigital.isNineDigitPandigital(concatenationOfProducts)) {
                    Long longValue = Long.parseLong(concatenationOfProducts);
                    if (longValue > max) {
                        max = longValue;
                    }
                }
            }
        }

        return max;
    }

    @Override
    public String base64EncodedAnswer() {
        return "OTMyNzE4NjU0";
    }
}
