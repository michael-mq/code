package Algorithm.LeetCode.LeetCode_152_Maximum_Product_Subarray;

// https://leetcode.cn/problems/maximum-product-subarray/solutions/2968916/dong-tai-gui-hua-jian-ji-gao-xiao-python-i778
class Solution_DP {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] iMax = new int[nums.length];
        int[] iMin = new int[nums.length];

        iMax[0] = nums[0];
        iMin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            iMax[i] = Math.max(Math.max(iMax[i - 1] * nums[i], iMin[i - 1] * nums[i]), nums[i]);
            iMin[i] = Math.min(Math.min(iMax[i - 1] * nums[i], iMin[i - 1] * nums[i]), nums[i]);
            max = Math.max(max, iMax[i]);
        }

        return max;
    }
}
