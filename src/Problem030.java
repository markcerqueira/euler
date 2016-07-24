import support.Problem;

/**
 * Created by Mark on 7/21/16.
 *
 * https://projecteuler.net/problem=30
 */
public class Problem030 extends Problem {

    @Override
    public long solveProblem() {
        long digitLength = 5;

        long answer = 0;

        // Our maximum number can be 99_999 and its maximum sum can be (9^5)+(9^5)+(9^5)+(9^5)+(9^5) or (9^5) * 5
        for (long l = 2; l < Math.pow(9, digitLength) * digitLength; l++) {
            String string = "" + l;

            long sum = 0;
            for (int i = 0; i < string.length(); i++) {
                sum += Math.pow(string.charAt(i) - '0', 5);
            }

            answer += sum == l ? sum : 0;
        }

        return answer;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NDQzODM5";
    }
}
