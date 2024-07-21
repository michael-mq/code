package Algorithm.LeetCode.LeetCode_53_Maximum_Subarray;

public class Solution_DP1 {
    // For SUBARRAY, you CANNOT skip the current element because the subarray has to be continuous.
    // You need to either include the previous subarray, or start it over
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
