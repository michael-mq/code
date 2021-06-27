package Algorithm.LeetCode.LeetCode_129_Sum_Root_to_Leaf_Numbers;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_DFS {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int preSum) {
       if (node == null) {
           return 0;
       }

       preSum = preSum * 10 + node.val;

       if (node.left == null && node.right == null) {
           return preSum;
       } else {
           return dfs(node.left, preSum) + dfs(node.right, preSum);
       }
    }
}
