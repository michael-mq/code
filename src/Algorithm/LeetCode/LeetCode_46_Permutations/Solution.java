package Algorithm.LeetCode.LeetCode_46_Permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        int depth = 0;

        dfs(nums, res, used, path, depth);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, boolean[] used, Deque<Integer> path, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);

                dfs(nums, res, used, path, depth + 1);

                used[i] = false;
                path.removeLast();
            }
        }
    }
}
