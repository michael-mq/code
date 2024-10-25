package Algorithm.LeetCode.LeetCode_55_Jump_Game;

import java.util.Arrays;

class Solution_DFS_MEMO {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(nums, 0, memo);
    }

    private boolean dfs(int[] nums, int index, int[] memo) {
        if (memo[index] != -1) {
            return memo[index] != 0;
        }

        if (index == nums.length - 1) {
            return true;
        }
        
        for (int i = index + 1; i <= Math.min(index + nums[index], nums.length - 1); i++) {
            if (dfs(nums, i, memo)) {
                memo[i] = 1;
                return true;
            }
        }

        memo[index] = 0;
        return false;
    }
}