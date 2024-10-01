class Solution {

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        String answer = "";

        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i < s.length(); j++) {
                if (isPalindrome(s, j, j + i)) {
                    if (answer.length() < s.substring(j, j + i + 1).length()) {
                        System.out.println("in here");
                        answer = s.substring(j, j + i + 1);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}