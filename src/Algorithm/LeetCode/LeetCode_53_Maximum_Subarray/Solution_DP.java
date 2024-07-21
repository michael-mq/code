package Algorithm.LeetCode.LeetCode_53_Maximum_Subarray;

class Solution_DP {
    // For SUBARRAY, you CANNOT skip the current element because the subarray has to be continuous.
    // You need to either include the previous subarray, or start it over
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];

        for (int n : nums) {
            pre = Math.max(n, pre + n);
            max = Math.max(pre, max);
        }

        return max;
    }
}
