import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        char[] cArr = s.toLowerCase().toCharArray();
        StringBuilder str = new StringBuilder();

        for (char c: cArr) {
            if (Character.isLetterOrDigit(c)) {
                str.append(c);
            }
        }

        String original = str.toString();
        String reverse = str.reverse().toString();

        return original.equals(reverse);
    }
}