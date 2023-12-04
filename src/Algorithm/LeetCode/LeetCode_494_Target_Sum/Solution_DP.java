package Algorithm.LeetCode.LeetCode_494_Target_Sum;

// https://www.programmercarl.com/0494.目标和.html
class Solution_DP {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) sum += nums[i];

        // All the nums are non-negative, 0 <= nums[i] <= 1000
        // 如果target过大 sum将无法满足
        // if (target < 0 && sum < -target) return 0;
        if (Math.abs(target) > sum) return 0;

        if ((target + sum) % 2 != 0) return 0;

        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[size];
    }
}