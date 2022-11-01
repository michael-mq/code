package Algorithm.LeetCode.LeetCode_75_Sort_Colors;

// https://www.youtube.com/watch?v=aVOm2Kickys
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;

        if (len < 2)
            return;

        int zero = -1;
        int two = len;

        int i = 0;

        while (i < two) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
