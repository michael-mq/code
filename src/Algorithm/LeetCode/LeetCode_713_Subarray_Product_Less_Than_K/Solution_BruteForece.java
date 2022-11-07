package Algorithm.LeetCode.LeetCode_713_Subarray_Product_Less_Than_K;

class Solution_BruteForece {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            long product = nums[i];

            if (product >= k) {
                continue;
            }

            result++;

            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];

                if (product >= k) {
                    break;
                }

                result++;
            }
        }

        return result;
    }
}