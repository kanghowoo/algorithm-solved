class Solution {

    private boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++ ) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getAllIndexes(String s, char letter, int offset) {
        List<Integer> indexes = new ArrayList();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == letter) {
                indexes.add(i + offset);
            }
        }
        return indexes;
    }
    
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            List<Integer> indexes = getAllIndexes(s.substring(i), s.charAt(i), i);
            for (Integer index: indexes) {
                if (isPalindrom(s.substring(i, index + 1))) {
                    if (result.length() < s.substring(i, index + 1).length()) {
                        result = s.substring(i, index + 1);
                    }
                    break;
                }
            }
        }
        return result;
    }

}