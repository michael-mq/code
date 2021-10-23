package Algorithm.LeetCode.LeetCode_53_Maximum_Subarray;

class Solution_DP {
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
