package Algorithm.LeetCode.LeetCode_80_Remove_Duplicates_from_Sorted_Array_II;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solutions/702970/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (i < 2) {
                i++;
                continue;
            }

            if (nums[i - 2] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}