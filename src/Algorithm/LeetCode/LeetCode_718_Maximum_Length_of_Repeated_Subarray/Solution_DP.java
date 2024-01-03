package Algorithm.LeetCode.LeetCode_718_Maximum_Length_of_Repeated_Subarray;

//https://www.programmercarl.com/0718.最长重复子数组.html
class Solution_DP {
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}