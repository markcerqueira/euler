import support.Palindrome;
import support.Problem;

/**
 * Created by Mark on 7/22/16.
 *
 * https://projecteuler.net/problem=36
 */
public class Problem036 extends Problem {

    @Override
    public long solveProblem() {
        long sumDoubleBasePalindromes = 0;

        for (int i = 0; i < 1_000_000; i++) {
            if (Palindrome.isPalindrome(i) && Palindrome.isPalindrome(Integer.toBinaryString(i))) {
                sumDoubleBasePalindromes += i;
            }
        }


        return sumDoubleBasePalindromes;
    }

    @Override
    public String base64EncodedAnswer() {
        return "ODcyMTg3";
    }
}
