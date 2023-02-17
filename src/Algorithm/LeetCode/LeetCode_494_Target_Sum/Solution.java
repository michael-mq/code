package Algorithm.LeetCode.LeetCode_494_Target_Sum;

class Solution {
    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(0, nums, target);

        return res;
    }

    private void dfs(int index, int[] nums, int target) {
        if (index == nums.length) {
            if (target == 0) {
                res++;
            }

            return;
        }

        dfs(index + 1, nums, target + nums[index]);
        dfs(index + 1, nums, target - nums[index]);
    }
}