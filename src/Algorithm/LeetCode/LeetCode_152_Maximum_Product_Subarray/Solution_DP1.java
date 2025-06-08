package Algorithm.LeetCode.LeetCode_152_Maximum_Product_Subarray;

// https://leetcode.cn/problems/maximum-product-subarray/solutions/7561/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g
public class Solution_DP1 {
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
        Solution_DP1 foo = new Solution_DP1();

        System.out.println(foo.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(foo.maxProduct(new int[]{-2, 0, -1}));
    }
}