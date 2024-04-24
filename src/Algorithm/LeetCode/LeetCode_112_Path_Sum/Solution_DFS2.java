package Algorithm.LeetCode.LeetCode_112_Path_Sum;

class Solution_DFS2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean[] res = new boolean[1];

        dfs(root, 0, targetSum, res);

        return res[0];
    }

    private void dfs(TreeNode root, int sum, int targetSum, boolean[] res) {
        if (root == null) {
            return;
        }

        sum += root.val;

        if (root.left == null && root.right == null && sum == targetSum) {
            res[0] = true;
        }

        dfs(root.left, sum, targetSum, res);
        dfs(root.right, sum, targetSum, res);
    }
}
