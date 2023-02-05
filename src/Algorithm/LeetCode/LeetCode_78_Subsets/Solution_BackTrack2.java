package Algorithm.LeetCode.LeetCode_78_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution_BackTrack2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        result.add(path);

        dfs(nums, result, path, 0);

        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, int start) {
        for (int i = start; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                result.add(new ArrayList<>(path));

                dfs(nums, result, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}