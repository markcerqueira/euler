import support.Factors;
import support.Problem;

import java.util.List;

/**
 * Created by Mark on 7/17/16.
 *
 * https://projecteuler.net/problem=12
 */
public class Problem12 extends Problem {

    @Override
    public long solveProblem() {
        long triangleNumber = 0;
        for (int i = 1; ; i++) {
            triangleNumber += i;

            if (Factors.getFactors(triangleNumber).size() > 500) {
                return triangleNumber;
            }
        }
    }

    @Override
    public String base64EncodedAnswer() {
        return "NzY1NzY1MDA=";
    }
}
