package Algorithm.LeetCode.LeetCode_55_Jump_Game;

class Solution_DP_MyOwn {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n && j <= i + nums[i]; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}