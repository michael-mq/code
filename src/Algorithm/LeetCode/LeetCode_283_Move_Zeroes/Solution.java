package Algorithm.LeetCode.LeetCode_283_Move_Zeroes;

import java.util.Arrays;

// https://youtu.be/md032bqR22U?t=4675
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int j = 0;
        // 第一次遍历：将非零元素挪到前面
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                // 优化点：只有当 i 和 j 不相等时才赋值
                // 如果相等，说明还没遇到 0，元素本来就在正确的位置上
                if (i != j) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }

        // 第二次遍历：将剩余位置补零
        for (int i = j; i < nums.length; ++i) {
            // 优化点：如果当前位置已经是 0 了，就没必要再写一遍 0
            if (nums[i] != 0) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] foo = new int[]{0, 1, 0, 3, 12};

        solution.moveZeroes(foo);
        System.out.println(Arrays.toString(foo));
    }
}
