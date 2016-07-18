package support;

import java.util.ArrayList;
import java.util.List;

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

}
