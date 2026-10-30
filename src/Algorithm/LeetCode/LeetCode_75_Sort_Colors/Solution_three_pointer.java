package Algorithm.LeetCode.LeetCode_75_Sort_Colors;

// https://youtu.be/md032bqR22U 1:19:00
public class Solution_three_pointer {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 自己画图

        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                // i 是探路者，它永远跑在 left 的前面或与 left 重合（i >= left）
                // 当 i == left 时，说明 i 在探路的过程中，还没有遇到过任何 1
                // 当 i > left 时（重点），在 left 位置上，以及 left 到 i 之间的所有元素，全部都是 1
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--;
                // Stay and check again
                // 从 right 换到 i 位置的数字，你从没见过。它可能是 2，可能是 1，也可能是个 0
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
