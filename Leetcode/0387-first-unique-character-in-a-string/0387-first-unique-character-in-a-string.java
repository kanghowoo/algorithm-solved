import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        int left = 0, right = 0;

        char[] charArr = s.toCharArray();

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = charArr[i];
            freq[c - 'a']++;
        }

        for (int j = 0; j < s.length(); j++) {
            char c = charArr[j];
            if (freq[c - 'a'] == 1) return j;
        }

        return -1;


    }
}