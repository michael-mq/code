package Algorithm.LeetCode.LeetCode_55_Jump_Game;

class Solution_DFS_TIMEOUT {
    public boolean canJump(int[] nums) {
        return dfs(0, nums);
    }

    private boolean dfs(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int i = position + 1; i <= furthestJump; i++) {
            if (dfs(i, nums)) {
                return true;
            }
        }

        return false;
    }
}