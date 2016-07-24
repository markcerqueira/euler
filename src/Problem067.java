import support.Problem;

/**
 * Created by Mark on 7/19/16.
 *
 * https://projecteuler.net/problem=67
 */
public class Problem067 extends Problem {

    @Override
    public long solveProblem() throws Exception {
        // Problem 18 is the same problem but with a smaller dataset.
        return Problem018.solveMaximumPathSum("/resources/67.txt");
    }

    @Override
    public String base64EncodedAnswer() {
        return "NzI3Mw==";
    }
}
