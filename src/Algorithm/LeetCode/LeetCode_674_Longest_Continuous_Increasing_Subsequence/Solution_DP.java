package Algorithm.LeetCode.LeetCode_674_Longest_Continuous_Increasing_Subsequence;

//https://www.programmercarl.com/0674.最长连续递增序列.html
class Solution_DP {
    public int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int length = nums.length;
        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

            result = Math.max(dp[i], result);
        }

        return result;
    }
}