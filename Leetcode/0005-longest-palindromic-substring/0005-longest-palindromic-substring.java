class Solution {

    public static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        String result = "";

        for (int i = len; i > 0; i--) {
            for (int j = 0; j + i <= len; j++) {
                if (isPalindrome(s, j, j+i-1)) {
                    if (result.length() < s.substring(j, j+i).length()) {
                        result = s.substring(j, j+i);
                    }
                    break;
                }
            }
        }

        return result;

    }
}