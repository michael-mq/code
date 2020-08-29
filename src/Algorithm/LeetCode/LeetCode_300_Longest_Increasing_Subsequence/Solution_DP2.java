package Algorithm.LeetCode.LeetCode_300_Longest_Increasing_Subsequence;

public class Solution_DP2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxAns = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }

            dp[i] = maxVal + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        Solution_DP2 foo = new Solution_DP2();

        System.out.println(foo.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
