package Algorithm.LeetCode.LeetCode_456_132_Pattern;

class Solution_Brute_Force_Timeout {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return false;
        }

        for (int k = 2; k < n; k++) {
            for (int j = 1; j < k; j++) {
                for (int i = 0; i < j; i++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}