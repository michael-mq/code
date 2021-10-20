package Algorithm.LeetCode.LeetCode_189_Rotate_Array;

// https://www.youtube.com/watch?v=BHr381Guz3Y
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        k %= len;

        swap(nums, 0, len - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, len - 1);
    }

    private void swap(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }
    }
}
