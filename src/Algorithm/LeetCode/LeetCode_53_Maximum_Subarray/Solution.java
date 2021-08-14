package Algorithm.LeetCode.LeetCode_53_Maximum_Subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] foo = new int[nums.length];
        int max = nums[0];
        foo[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            foo[i] = foo[i - 1] > 0 ? foo[i - 1] + nums[i] : nums[i];
            max = Math.max(max, foo[i]);
        }

        return max;
    }
}
