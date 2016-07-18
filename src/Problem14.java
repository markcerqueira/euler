import support.Problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 7/17/16.
 *
 * https://projecteuler.net/problem=14
 */
public class Problem14 extends Problem {

    @Override
    public long solveProblem() {
        int longestSequenceSource = 0;
        int longestSequenceLength = 0;

        for (int i = 1; i < 1_000_000; i++) {
            int length = getCollatzSequenceLength(i);

            if (length > longestSequenceLength) {
                longestSequenceSource = i;
                longestSequenceLength = length;
            }
        }

        return longestSequenceSource;
    }

    // Memoization! Once we see a number we've calculated the sequence length for we can return our current sequence
    // length with that stored value (and store this new length of course).
    private Map<Integer, Integer> numberToCollatzSequenceLengthMap = new HashMap<>();

    private int getCollatzSequenceLength(int num) {
        int length = 0;

        long mutatingNum = num;
        while (mutatingNum != 1) {
            // We hit a number we already calculated so add that previous answer and break out.
            if (numberToCollatzSequenceLengthMap.containsKey(mutatingNum)) {
                length += numberToCollatzSequenceLengthMap.get(mutatingNum);
                break;
            }

            if (mutatingNum % 2 == 0) {
                mutatingNum = mutatingNum / 2;
            } else {
                mutatingNum = 3 * mutatingNum + 1;
            }

            length++;
        }

        numberToCollatzSequenceLengthMap.put(num, length);

        // We break one mutatingNum != 1 but 1 is a part of the chain so add +1 to return the proper value.
        length = length + 1;

        return length;
    }
}
