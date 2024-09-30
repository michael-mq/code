package Algorithm.LeetCode.LeetCode_209_Minimum_Size_Subarray_Sum;

class Solution_MyOwn {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }

        if (nums[0] >= target) {
            return 1;
        }

        int i = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;

        for (int j = 1; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
