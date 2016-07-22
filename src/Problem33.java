import support.Factors;
import support.Problem;

import java.util.HashMap;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=33
 */
public class Problem33 extends Problem {

    @Override
    public long solveProblem() {
        long numeratorAnswer = 1;
        long denominatorAnswer = 1;

        for (int numerator = 10; numerator < 100; numerator++) {
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                // Ignore trivial examples
                if (numerator % 10 == 0 && denominator % 10 == 0) {
                    continue;
                }

                String numStr = "" + numerator;
                String denStr = "" + denominator;

                int[] indices = {0, 1};

                for (int index : indices) {
                    if (denStr.contains("" + numStr.charAt(index))) {
                        int newNumerator = Integer.parseInt(numStr.replaceFirst("" + numStr.charAt(index), ""));
                        int newDenominator = Integer.parseInt(denStr.replaceFirst("" + numStr.charAt(index), ""));

                        if ((float) numerator / denominator == (float) newNumerator / newDenominator ) {
                            numeratorAnswer *= numerator;
                            denominatorAnswer *= denominator;
                        }
                    }
                }
            }
        }

        // We now have the 4 special fractions but need to return the denominator product once the answer fraction is
        // reduced (i.e. divide the current denominator by the greatest common denominator).
        return denominatorAnswer / Factors.greatestCommonDenominator(numeratorAnswer, denominatorAnswer);
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTAw";
    }
}
