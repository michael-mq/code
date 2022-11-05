package Algorithm.LeetCode.LeetCode_283_Move_Zeroes;

import java.util.Arrays;

public class Solution3 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 1;

        while (j < nums.length) {
            if (nums[i] == 0) {
                if (nums[j] != 0) {
                    swap(nums, i, j);
                    i++;
                }
            } else {
                i++;
            }

            j++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        int[] foo = new int[]{0, 1, 0, 3, 12};

        solution.moveZeroes(foo);
        System.out.println(Arrays.toString(foo));
    }
}
