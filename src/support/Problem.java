package support;

import javafx.util.Pair;

/**
 * Created by Mark on 7/14/16.
 */
public abstract class Problem {

    // Result is pair where first number is answer and second answer is running time in milliseconds
    public Pair<Long, Long> solve() {
        long currentTime = System.currentTimeMillis();
        return new Pair<>(solveProblem(), (System.currentTimeMillis() - currentTime));
    }

    public abstract long solveProblem();
}
