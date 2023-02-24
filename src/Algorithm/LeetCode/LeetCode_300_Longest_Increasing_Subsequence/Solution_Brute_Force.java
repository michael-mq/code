package Algorithm.LeetCode.LeetCode_300_Longest_Increasing_Subsequence;

class Solution_Brute_Force {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[1];

        for (int i = 0; i < nums.length; i++) {
            dfs(nums, -1, i, 0, res);
        }

        return res[0];
    }

    void dfs(int[] nums, int prev, int curr, int len, int[] res) {
        len++;

        if (curr == nums.length) {
            res[0] = Math.max(res[0], len - 1);

            return;
        }

        if (prev >= 0 && nums[curr] <= nums[prev]) {
            res[0] = Math.max(res[0], len - 1);

            return;
        }

        for (int i = curr + 1; i <= nums.length; i++) {
            dfs(nums, curr, i, len, res);
        }
    }
}