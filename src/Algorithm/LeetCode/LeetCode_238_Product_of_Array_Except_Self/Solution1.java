package Algorithm.LeetCode.LeetCode_238_Product_of_Array_Except_Self;

public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        int[] result = new int[len];

        arr1[0] = 1;
        for (int i = 1; i < len; i++) {
            arr1[i] = nums[i - 1] * arr1[i - 1];
        }

        arr2[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            arr2[i] = nums[i + 1] * arr2[i + 1];
        }

        for (int i = 0; i < len; i++) {
            result[i] = arr1[i] * arr2[i];
        }

        return result;
    }
}
