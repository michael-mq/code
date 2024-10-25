package Algorithm.LeetCode.LeetCode_40_Combination_Sum_II;

import java.util.*;

class Solution_MyOwn {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int target, int index, int sum, List<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = index; i < candidates.length; i++) {
            if (set.contains(candidates[i])) {
                continue;
            }

            set.add(candidates[i]);

            if (candidates[i] > target) {
                return;
            }

            path.add(candidates[i]);
            dfs(candidates, target, i + 1, sum + candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}