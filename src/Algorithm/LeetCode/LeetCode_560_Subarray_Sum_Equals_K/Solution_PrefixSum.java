package Algorithm.LeetCode.LeetCode_560_Subarray_Sum_Equals_K;

public class Solution_PrefixSum {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        int count = 0;
        int[] preSum = new int[len + 1];

        preSum[0] = 0;

        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
