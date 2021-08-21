package Algorithm.LeetCode.LeetCode_101_Symmetric_Tree;

import java.util.Stack;

public class Solution_Stack {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root.left);
        stack.push(root.right);

        while (stack.size() > 0) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);

            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Stack foo = new Solution_Stack();

        TreeNode root;

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);

        System.out.println(foo.isSymmetric(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(3);

        System.out.println(foo.isSymmetric(root));
    }
}
