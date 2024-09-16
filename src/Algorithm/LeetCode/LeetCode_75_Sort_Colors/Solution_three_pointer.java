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
                // i moves because
                // 1. `i` comes from the left
                // 2. `i` is at the same or further place than `left`
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--; // Stay and check again. We don't know what was swapped from nums[right], might be 2
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
