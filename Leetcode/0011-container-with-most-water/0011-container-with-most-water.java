class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int amt = h * (right - left);
            result = Math.max(result, amt);

            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }

        return result;
    }
}