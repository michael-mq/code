package Algorithm.LeetCode.LeetCode_1099_Two_Sum_Less_Than_K;

import java.util.Arrays;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length <= 1) {
            return -1;
        }

        Arrays.sort(nums);

        int res = 0;
        int i = 0;
        int j = nums.length - 1;

        while (nums[j] >= k) {
            j--;
        }

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (nums[i] + nums[j] >= k) {
                j--;
            } else {
                res = Math.max(res, sum);
                i++;
            }
        }

        return res == 0 ? -1 : res;
    }
}