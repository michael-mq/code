package Algorithm.LeetCode.LeetCode_268_Missing_Number;

class Solution_1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] hash = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            hash[nums[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!hash[i]) {
                return i;
            }
        }

        return n;
    }
}
