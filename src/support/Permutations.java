package support;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Mark on 7/24/16.
 */
public class Permutations {

    // http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
    public static void permutations(String string, Collection<String> results) {
        permute("", string, results);
    }

    private static void permute(String prefix, String s, Collection<String> results) {
        int n = s.length();
        if (n == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), results);
            }
        }

    }
}
