package Algorithm.LeetCode.LeetCode_114_Flatten_Binary_Tree_to_Linked_List;

import java.util.LinkedList;
import java.util.Queue;

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
class Solution_MyOwn {
    private Queue<TreeNode> q;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        q = new LinkedList<>();

        dfs(root);

        root = q.poll();
        root.left = null;
        TreeNode head = root;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            node.left = null;
            head.right = node;
            head = node;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        q.offer(root);

        dfs(root.left);
        dfs(root.right);
    }
}