package Algorithm.LeetCode.LeetCode_213_House_Robber_II;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        return Math.max(
                robRange(nums, 0, n - 2),
                robRange(nums, 1, n - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;

        for (int i = end; i >= start; i--) {
            dp_i = Math.max(
                    dp_i_1,
                    nums[i] + dp_i_2
            );

            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i;
    }
}
