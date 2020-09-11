package Algorithm.LeetCode.LeetCode_238_Product_of_Array_Except_Self;

public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] result = new int[len];

        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = r * result[i];
            r *= nums[i];
        }

        return result;
    }
}
