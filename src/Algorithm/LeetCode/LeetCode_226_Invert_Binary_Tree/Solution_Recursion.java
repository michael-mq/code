package Algorithm.LeetCode.LeetCode_226_Invert_Binary_Tree;

public class Solution_Recursion {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        Solution_Recursion solutionMyOwn = new Solution_Recursion();

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
