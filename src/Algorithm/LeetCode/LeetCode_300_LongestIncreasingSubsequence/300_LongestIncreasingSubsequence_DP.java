package Algorithm.LeetCode.LeetCode_300_LongestIncreasingSubsequence;

import java.util.*;

class LongestIncreasingSubsequence_DP {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return len;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}

class LongestIncreasingSubsequenceMain_DP_300 {
    public static void main(String[] args) {
        LongestIncreasingSubsequence_DP longestIncreasingSubsequence_DP = new LongestIncreasingSubsequence_DP();

        System.out.println(longestIncreasingSubsequence_DP.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
