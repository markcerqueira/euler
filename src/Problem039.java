import support.Integers;
import support.Problem;

/**
 * Created by Mark on 7/23/16.
 *
 * https://projecteuler.net/problem=39
 */
public class Problem039 extends Problem {

    @Override
    public long solveProblem() {
        // For all valid integral numbers we will track their occurrence count here
        int[] solutions = new int[1001];

        for (int a = 1; a <= 1000; a++) {
            for (int b = 1; a + b <= 1000; b++) {
                double c = Math.sqrt(a * a + b * b);

                if (Integers.isIntegral(c) && a + b + c <= 1000) {
                    solutions[a + b + (int) c]++;
                }
            }
        }

        long maxSolutions = 0;
        long maxIndex = 0;
        for (int i = 0; i < solutions.length; i++) {
            if (solutions[i] > maxSolutions) {
                maxSolutions = solutions[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    @Override
    public String base64EncodedAnswer() {
        return "ODQw";
    }
}
