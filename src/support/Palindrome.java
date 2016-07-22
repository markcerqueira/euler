package support;

/**
 * Created by Mark on 7/15/16.
 */
public class Palindrome {

    // http://stackoverflow.com/a/4138856/265791
    public static boolean isPalindrome(long l) {
        return isPalindrome("" + l);
    }

    public static boolean isPalindrome(String str) {
        return isPalindrome(str.toCharArray());
    }

    public static boolean isPalindrome(char[] chars) {
        int i1 = 0;
        int i2 = chars.length - 1;
        while (i2 > i1) {
            if (chars[i1] != chars[i2]) {
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }
}
