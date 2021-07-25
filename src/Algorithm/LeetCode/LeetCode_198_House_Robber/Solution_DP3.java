package Algorithm.LeetCode.LeetCode_198_House_Robber;

import java.util.Arrays;

public class Solution_DP3 {
    public int rob(int[] nums) {
        // 初始化备忘录
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0, memo);
    }

    private int dp(int[] nums, int start, int[] memo) {
        if (start >= nums.length)
            return 0;
        // 避免重复计算
        if (memo[start] != -1)
            return memo[start];

        int res = Math.max(dp(nums, start + 1, memo),
                nums[start] + dp(nums, start + 2, memo));
        // 记入备忘录
        memo[start] = res;

        return res;
    }
}
