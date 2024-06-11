package Algorithm.LeetCode.LeetCode_2863_Maximum_Length_of_Semi_Descreasing_Subarrays;

class Solution_BF_MyOwn {
    public int maxSubarrayLength(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }
}