package Algorithm.LeetCode.LeetCode_530_Minimum_Absolute_Difference_in_BST;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int pre = -1000000;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        dfs(root);

        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        min = Math.min(min, root.val - pre);

        pre = root.val;

        dfs(root.right);
    }
}