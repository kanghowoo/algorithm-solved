class Solution {

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        String answer = "";
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i,j);
                if (isPalindrome(str) && max < str.length()) {
                        answer = str;
                        max = str.length();
                }
            }
        }

        return answer;
    }
}