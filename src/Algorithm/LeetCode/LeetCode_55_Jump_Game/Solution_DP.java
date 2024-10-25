package Algorithm.LeetCode.LeetCode_55_Jump_Game;

import java.util.Arrays;

//https://leetcode.com/problems/jump-game/editorial/#approach-3-dynamic-programming-bottom-up
class Solution_DP {
    enum Index {
        GOOD,
        BAD
    }

    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        Arrays.fill(memo, Index.BAD);
        memo[nums.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(nums.length - i - 1, nums[i]);

            for (int j = furthestJump + i; j > i; j--) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
}