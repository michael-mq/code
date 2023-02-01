package Algorithm.LeetCode.LeetCode_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(candidates, 0, 0, target, new ArrayList<>());

        return result;
    }

    private void dfs(int[] candidates, int index, int sum, int target, List<Integer> list) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, i, sum + candidates[i], target, list);
            list.remove(list.size() - 1);
        }
    }
}