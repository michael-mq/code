package Algorithm.LeetCode.LeetCode_55_Jump_Game;

import java.util.Arrays;

//https://leetcode.com/problems/jump-game/editorial/#approach-2-dynamic-programming-top-down
class Solution_DFS_MEMO {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(nums, 0, memo);
    }

    boolean dfs(int[] nums, int index, int[] memo) {
        if (memo[index] != -1) {
            return memo[index] == 1;
        }

        if (nums[index] + index >= nums.length - 1) {
            // memo[index] = 1; // This doesn't matter because the first true will make the code end, and no need to memo
            return true;
        }

        for (int i = index + 1; i <= index + nums[index]; i++) {
            if (dfs(nums, i, memo)) {
                // memo[i] = 1; // As above
                return true;
            }
        }

        memo[index] = 0; // This matters
        return false;
    }
}