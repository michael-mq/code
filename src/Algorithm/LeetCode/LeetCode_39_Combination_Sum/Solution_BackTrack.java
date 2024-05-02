package Algorithm.LeetCode.LeetCode_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution_BackTrack {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();


        backTrack(candidates, target, 0, 0, path, res);

        return res;

    }

    private void backTrack(int[] candidates, int target, int startIndex, int sum, List<Integer> path, List<List<Integer>> res) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];

            // Only works when the candidates is sorted. Think why
            // https://www.programmercarl.com/0039.组合总和.html#剪枝优化
            // if (sum > target) {
            //     return;
            // }

            path.add(candidates[i]);
            backTrack(candidates, target, i, sum, path, res);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
