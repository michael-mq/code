package Algorithm.LeetCode.LeetCode_152_Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            max = Math.max(max, iMax);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        System.out.println(foo.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(foo.maxProduct(new int[]{-2, 0, -1}));
    }
}
