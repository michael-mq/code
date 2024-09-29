package Algorithm.LeetCode.LeetCode_26_Remove_Duplicates_from_Sorted_Array;

class Solution_MyOwn {
    public int removeDuplicates(int[] nums) {
        int left = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[left] = nums[i];
                left++;
            }
        }

        return left;
    }
}
