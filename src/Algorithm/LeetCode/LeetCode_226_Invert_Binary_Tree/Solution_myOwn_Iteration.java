package Algorithm.LeetCode.LeetCode_226_Invert_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_myOwn_Iteration {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();

            TreeNode temp = head.left;
            head.left = head.right;
            head.right = temp;

            if(head.left != null) {
                queue.add(head.left);
            }

            if(head.right != null) {
                queue.add(head.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Solution_myOwn_Iteration solutionMyOwn = new Solution_myOwn_Iteration();

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        solutionMyOwn.invertTree(root);

    }
}
