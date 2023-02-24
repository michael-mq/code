package Algorithm.LeetCode.LeetCode_945_Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

class Solution_Sort {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int pre = nums[i];
                nums[i] = nums[i - 1] + 1;
                res += nums[i] - pre;
            }
        }

        return res;
    }
}