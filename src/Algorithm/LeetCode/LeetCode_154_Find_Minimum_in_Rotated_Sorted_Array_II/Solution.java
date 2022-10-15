package Algorithm.LeetCode.LeetCode_154_Find_Minimum_in_Rotated_Sorted_Array_II;

// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/solution/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-de-zui--16/
class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            // because we have to rely on end to check if the left or right side contains the minimum
            // so we have to keep moving the end until it's not the same as mid anymore
            if (nums[end] == nums[mid]) {
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}