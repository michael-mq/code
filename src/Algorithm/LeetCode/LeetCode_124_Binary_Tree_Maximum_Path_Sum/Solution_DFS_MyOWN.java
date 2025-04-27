package Algorithm.LeetCode.LeetCode_124_Binary_Tree_Maximum_Path_Sum;

class Solution_DFS_MyOWN {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        if (leftMax < 0 && rightMax < 0) {
            ans = Math.max(ans, root.val);
        } else if (leftMax < 0) {
            ans = Math.max(ans, rightMax + root.val);
        } else if (rightMax < 0) {
            ans = Math.max(ans, leftMax + root.val);
        } else {
            ans = Math.max(ans, leftMax + rightMax + root.val);
        }

        int max = Math.max(leftMax, rightMax);

        if (max < 0) {
            return root.val;
        }

        return max + root.val;
    }
}