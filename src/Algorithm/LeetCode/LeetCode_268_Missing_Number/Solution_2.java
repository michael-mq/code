package Algorithm.LeetCode.LeetCode_268_Missing_Number;

class Solution_2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int cur = 0;
        int sum = n * (n + 1) / 2;

        for (int i : nums) {
            cur += i;
        }

        return sum - cur;
    }
}
