package Algorithm.LeetCode.LeetCode_404_Sum_of_Left_Leaves;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        dfs(root.left);
        dfs(root.right);
    }
}