class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 1;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
                answer = Math.max(answer, set.size());
            }
        }

        if (s.length() == 0) answer = 0;

        return answer;
    }
}