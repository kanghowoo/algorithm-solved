class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        int answer = -1;

        while (start < end) {
            mid = (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                answer = mid;
                break;
            }
        }

        return answer;
    }
}