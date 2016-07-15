package support;

import javafx.util.Pair;

/**
 * Created by Mark on 7/14/16.
 */
public abstract class Problem {

    // Result is pair where first number is answer and second answer is running time in seconds
    public Pair<Long, Long> solve() {
        long currentTime = System.currentTimeMillis();
        long answer = solveProblem();
        long endTime = System.currentTimeMillis();

        return new Pair<>(answer, ((endTime - currentTime) / 1000));
    }

    public abstract long solveProblem();
}
