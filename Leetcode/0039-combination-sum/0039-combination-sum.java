import java.util.*;

class Solution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        findCombinations(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void findCombinations(int[] candidates, int target, int start, 
        List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;

            current.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}