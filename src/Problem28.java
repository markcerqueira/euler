import support.Problem;

/**
 * Created by Mark on 7/23/16.
 *
 * https://projecteuler.net/problem=28
 */
public class Problem28 extends Problem {

    @Override
    public long solveProblem() {
        long diagonalSum = 1;

        for (int i = 2; i <= 1001; i += 2) {
            // Calculate the last number from the previous grid
            long lastNum = (i - 1) * (i - 1);

            // The four numbers in this grid can be calculated from the above number and the length of our current grid
            diagonalSum += lastNum + i;
            diagonalSum += lastNum + 2 * i;
            diagonalSum += lastNum + 3 * i;
            diagonalSum += lastNum + 4 * i;
        }

        return diagonalSum;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NjY5MTcxMDAx";
    }
}
