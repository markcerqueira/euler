package support;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 7/14/16.
 */
public class Fibonacci {

    private static Map<Long, Long> fibonacciResults = new HashMap<>();

    // http://stackoverflow.com/a/24816852/265791
    public static long memoizedFib(long n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (fibonacciResults.get(n) != null) {
            return fibonacciResults.get(n);
        } else {
            long value = memoizedFib(n - 1) + memoizedFib(n - 2);
            fibonacciResults.put(n, value);
            return value;
        }
    }

}
