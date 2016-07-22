import support.Factorial;
import support.Problem;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=34
 */
public class Problem34 extends Problem {

    @Override
    public long solveProblem() {
        // Highest we can go is a 9 digit number with all 9s
        long UPPER_LIMIT = Factorial.factorial(9) * 9;

        long answer = 0;
        for (int i = 3; i < UPPER_LIMIT; i++) {
            String str = i + "";

            long factorialSum = 0;
            for (int j = 0; j < str.length(); j++) {
                factorialSum += Factorial.factorial(str.charAt(j) - '0');
            }

            if (factorialSum == i) {
                answer += i;
            }
        }

        return answer;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NDA3MzA=";
    }
}
