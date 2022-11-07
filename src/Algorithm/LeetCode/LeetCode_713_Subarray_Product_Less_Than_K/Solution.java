package Algorithm.LeetCode.LeetCode_713_Subarray_Product_Less_Than_K;

// https://leetcode.cn/problems/subarray-product-less-than-k/solution/jian-dan-yi-dong-xiang-xi-zhu-jie-shuang-jvy3/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int mul = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            mul *= nums[right];

            while (mul >= k) {
                mul /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
