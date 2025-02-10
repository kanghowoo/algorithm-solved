import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int idx = lowerBound(list, num);

            if (idx < list.size()) list.set(idx, num);
            else list.add(num);
        }

        return list.size();

    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}