package support;

import java.math.BigInteger;

/**
 * Created by Mark on 7/14/16.
 */
public class Prime {

    public static boolean isPrime(long num) {
        return BigInteger.valueOf(num).isProbablePrime(10); // 99% certainty
    }
}
