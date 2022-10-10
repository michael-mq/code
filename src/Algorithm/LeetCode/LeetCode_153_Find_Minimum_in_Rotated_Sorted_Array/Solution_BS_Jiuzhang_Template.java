package Algorithm.LeetCode.LeetCode_153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution_BS_Jiuzhang_Template {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
