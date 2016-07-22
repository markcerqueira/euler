package support;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 7/14/16.
 */
public class Prime {

    // http://stackoverflow.com/a/20798440/265791
    public static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(String num) {
        return isPrime(Long.parseLong(num));
    }

    // http://www.vogella.com/tutorials/JavaAlgorithmsPrimeFactorization/article.html
    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
}
