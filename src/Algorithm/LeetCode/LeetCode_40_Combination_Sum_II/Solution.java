package Algorithm.LeetCode.LeetCode_40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] candidates, int target, int startIndex, int sum, List<Integer> path, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];

            if (sum > target) {
                return;
            }

            if (i > startIndex && candidates[i - 1] == candidates[i]) {
                sum -= candidates[i];
                continue;
            }

            path.add(candidates[i]);
            backtrack(candidates, target, i + 1, sum, path, res);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}