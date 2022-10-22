package Algorithm.LeetCode.LeetCode_27_Remove_Element;

class Solution_Two_Pointer2 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}