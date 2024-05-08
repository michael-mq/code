package Algorithm.LeetCode.LeetCode_47_Permutations_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backTrack(nums, new boolean[nums.length], new ArrayList<>(), res);

        return res;
    }

    void backTrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        boolean[] usedSameLevel = new boolean[21];
        for(int i = 0; i < nums.length; i++) {
            if (used[i] || usedSameLevel[nums[i] + 10]) {
                continue;
            }

            usedSameLevel[nums[i] + 10] = true;
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums, used, path, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}