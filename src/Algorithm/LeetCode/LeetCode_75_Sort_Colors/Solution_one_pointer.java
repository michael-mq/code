package Algorithm.LeetCode.LeetCode_75_Sort_Colors;

// https://leetcode.cn/problems/sort-colors/solutions/437968/yan-se-fen-lei-by-leetcode-solution
public class Solution_one_pointer {
    public void sortColors(int[] nums) {
        int ptr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, ptr, i);
                ptr++;
            }
        }

        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, ptr, i);
                ptr++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
