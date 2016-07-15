package support;

/**
 * Created by Mark on 7/15/16.
 */
public class Palindrome {

    // http://stackoverflow.com/a/4138856/265791
    public static boolean isPalindrome(long l) {
        char[] str = new String(l + "").toCharArray();
        int i1 = 0;
        int i2 = str.length - 1;
        while (i2 > i1) {
            if (str[i1] != str[i2]) {
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }
}
