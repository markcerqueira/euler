import support.Factors;
import support.FileParser;
import support.Problem;

import java.util.*;

/**
 * Created by Mark on 7/20/16.
 *
 * https://projecteuler.net/problem=23
 */
public class Problem023 extends Problem {

    @Override
    public long solveProblem() {
        // Use a LinkedHashSet to get ordered goodness (and quick look-up access with contains() later on)
        Set<Integer> abundantNumbers = new LinkedHashSet<>();

        // Find all abundant numbers between 1 and 28_213
        for (int i = 1; i < 28_213; i++) {
            List<Integer> properDivisors = Factors.getProperDivisors(i);

            int properDivisorSum = 0;
            for (int properDivisor : properDivisors) {
                properDivisorSum += properDivisor;
            }

            if (i < properDivisorSum) {
                abundantNumbers.add(i);
            }
        }

        long sumOfNumbersThatAreNotSumOfTwoAbundantNumbers = 0;

        // For each number between 1 and 28_213 check if it can or cannot be the sum of two abundant numbers
        // For any number that cannot be the sum of two abundant numbers add it to our running total
        for (int i = 1; i < 28_213; i++) {
            boolean canBeSumOfTwoAbundantNumbers = false;

            for (int abundantNumber : abundantNumbers) {
                // If the abundant number we're looking at is greater than our current number we can stop for this number
                if  (abundantNumber > i) {
                    break;
                }

                // If our number - abundantNumber is in the abundantNumbers set, then we have two numbers that sum to it!
                if (abundantNumbers.contains(i - abundantNumber)) {
                    canBeSumOfTwoAbundantNumbers = true;
                    break;
                }
            }

            if (!canBeSumOfTwoAbundantNumbers) {
                sumOfNumbersThatAreNotSumOfTwoAbundantNumbers += i;
            }
        }

        return sumOfNumbersThatAreNotSumOfTwoAbundantNumbers;
    }

    @Override
    public String base64EncodedAnswer() {
        return "NDE3OTg3MQ==";
    }
}
