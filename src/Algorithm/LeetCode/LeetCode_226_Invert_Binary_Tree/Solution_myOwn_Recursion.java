package Algorithm.LeetCode.LeetCode_226_Invert_Binary_Tree;

public class Solution_myOwn_Recursion {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root);

        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        Solution_myOwn_Recursion solutionMyOwn = new Solution_myOwn_Recursion();

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
