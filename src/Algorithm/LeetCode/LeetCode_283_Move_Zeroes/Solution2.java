package Algorithm.LeetCode.LeetCode_283_Move_Zeroes;

import java.util.Arrays;

public class Solution2 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        //两个指针i和j
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] foo = new int[]{0, 1, 0, 3, 12};

        solution.moveZeroes(foo);
        System.out.println(Arrays.toString(foo));
    }
}
