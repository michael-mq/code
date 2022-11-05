package Algorithm.LeetCode.LeetCode_209_Minimum_Size_Subarray_Sum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }

        int result = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int subtotal = 0;

        while (i < nums.length && j < nums.length) {
            subtotal += nums[j];
            j++;

            while (i < j && subtotal >= target) {
                result = Math.min(result, j - i);
                subtotal -= nums[i];
                i++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
