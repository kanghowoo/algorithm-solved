import java.util.*;

class Solution {
    

    public int longestPalindrome(String s) {
        int[] nums = new int[52];

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                nums[c - 'a']++;
            }

            if (Character.isUpperCase(c)) {
                nums[c - 'A' + 26]++;
            }

        }

        int answer = 0;
        
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int odd = 0;

        for (int num : nums) {
            if (num % 2 == 0 && num != 0) {
                answer += num;
            }
            else if (num % 2 == 1 && num != 1) {
                answer += num - 1;
                odd = 1;
            }
            else if (num == 1) {
                odd = 1;
            }
        }

        return answer + odd;
    }
}