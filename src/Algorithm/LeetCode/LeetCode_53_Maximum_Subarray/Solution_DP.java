package Algorithm.LeetCode.LeetCode_53_Maximum_Subarray;

class Solution_DP {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];

        for (int n : nums) {
            pre = Math.max(n, pre + n);
            res = Math.max(pre, res);
        }

        return res;
    }
}
