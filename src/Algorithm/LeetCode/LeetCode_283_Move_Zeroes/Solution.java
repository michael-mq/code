package Algorithm.LeetCode.LeetCode_283_Move_Zeroes;

import java.util.Arrays;

// https://youtu.be/md032bqR22U?t=4675
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] foo = new int[]{0, 1, 0, 3, 12};

        solution.moveZeroes(foo);
        System.out.println(Arrays.toString(foo));
    }
}
