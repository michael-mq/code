package Algorithm.LeetCode.LeetCode_538_Convert_BST_to_Greater_Tree;

import java.util.Stack;

public class Solution_Iteration {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution_Iteration solutionIteration = new Solution_Iteration();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        TreeNode foo = solutionIteration.convertBST(root);

        root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);

        TreeNode bar = solutionIteration.convertBST(root);
    }
}
