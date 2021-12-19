package Algorithm.LeetCode.LeetCode_268_Missing_Number;

class Solution_3 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }

        for (int i : nums) {
            ans ^= i;
        }

        return ans;
    }
}
