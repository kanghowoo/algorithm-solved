import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        findPermutations(nums, new boolean[nums.length], new ArrayList<Integer>(), result);

        return result;
    }

    public void findPermutations(int[] nums, boolean[] visited,
        List<Integer> current, List<List<Integer>> result) {
        //탈출
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            current.add(nums[i]);
            findPermutations(nums, visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}