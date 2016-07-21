package support;

/**
 * Created by mcerqueira on 7/20/16.
 */
public class Factorial {

    public static long factorial(long num) {
        long factorial = 1;
        for (long l = 1; l <= num; l++) {
            factorial *= l;
        }
        return factorial;
    }
}
