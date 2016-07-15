package gg.mark.problems;

import gg.mark.support.Fibonacci;
import gg.mark.support.Problem;

/**
 * Created by Mark on 7/14/16.
 *
 * https://projecteuler.net/problem=2
 */
public class Problem2 extends Problem {

    @Override
    public long solveProblem() {
        long sum = 0;

        // Iterate until we reach Fibonacci value of over 4 million
        for (int l = 0; true; l++) {
            long fibonacciValue = Fibonacci.memoizedFib(l);
            if (fibonacciValue > 4_000_000) {
                break;
            }

            if (fibonacciValue % 2 == 0) {
                sum += fibonacciValue;
            }
        }

        return sum;
    }
}
