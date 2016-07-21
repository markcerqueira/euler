package support;

import java.util.*;

/**
 * Created by Mark on 7/17/16.
 */
public class Factors {

    public static List<Integer> getFactors(long num) {
        // Because a small factor has a large factor we don't need to go beyond the square root of our number
        double target = Math.sqrt(num);

        List<Integer> factorsList = new ArrayList<>();

        for (int i = 1; i <= target; i++) {
            if (num % i == 0) {
                // We found a factor so add it and add the corresponding "larger" factor
                factorsList.add(i);
                factorsList.add((int)num / i);
            }
        }

        return factorsList;
    }

    // proper divisors of num = numbers LESS THAN num which divide evenly into num
    public static List<Integer> getProperDivisors(long num) {
        if (num == 0 || num == 1) {
            return new ArrayList<>();
        }

        List<Integer> factors = getFactors(num);

        // Based on getFactors implementation, num will appear in index 1 (paired with the factor 1 in index 0)
        factors.remove(1);

        // Convert to a set to remove duplicates
        Set<Integer> divisors = new HashSet<>(factors);

        return new ArrayList<>(divisors);
    }
}
