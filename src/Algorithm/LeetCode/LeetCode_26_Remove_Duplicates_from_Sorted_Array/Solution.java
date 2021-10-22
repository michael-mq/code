package Algorithm.LeetCode.LeetCode_26_Remove_Duplicates_from_Sorted_Array;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int p = 0;
        int q = 0;

        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) { // Optimising
                    nums[p + 1] = nums[q];
                }
                p++;
            }

            q++;
        }

        return p + 1;
    }
}
