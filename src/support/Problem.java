package support;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import javafx.util.Pair;

/**
 * Created by Mark on 7/14/16.
 */
public abstract class Problem {

    // Result is pair where first number is answer and second answer is running time in milliseconds
    public Pair<Long, Long> solve() {
        try {
            long currentTime = System.currentTimeMillis();
            return new Pair<>(solveProblem(), (System.currentTimeMillis() - currentTime));
        } catch (Exception e) {
            System.out.println(e);
            return new Pair<>(-1L, -1L);
        }
    }

    public void runAndLogOutput() {
        Pair<Long, Long> answer = solve();
        System.out.println(getClass().getSimpleName() + ": " + answer.getKey() + " in " + answer.getValue() + " ms");

        // Validation: if we have a Base64 encoded answer, validate that the answer we calculated is correct.
        String base64EncodedAnswer = base64EncodedAnswer();
        if (base64EncodedAnswer != null) {
            // Only output if the answer is incorrect
            if (answer.getKey() != decodeBase64(base64EncodedAnswer)) {
                System.out.println("\tThe solution is not correct!");
            }
        }
    }

    private static long decodeBase64(String string) {
        try {
            return Long.parseLong(new String(Base64.decode(string.getBytes())));
        } catch (Exception e) {
            return -1;
        }
    }

    public abstract long solveProblem() throws Exception;

    public abstract String base64EncodedAnswer();
}
