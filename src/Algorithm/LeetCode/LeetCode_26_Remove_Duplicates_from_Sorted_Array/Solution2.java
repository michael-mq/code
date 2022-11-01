package Algorithm.LeetCode.LeetCode_26_Remove_Duplicates_from_Sorted_Array;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
class Solution2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }
}
