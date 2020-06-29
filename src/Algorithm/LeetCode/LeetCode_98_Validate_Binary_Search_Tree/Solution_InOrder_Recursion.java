package Algorithm.LeetCode.LeetCode_98_Validate_Binary_Search_Tree;

public class Solution_InOrder_Recursion {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 左
        if (!helper(root.left)) {
            return false;
        }

        // 中，因为知道中的值，所以可以比较
        if (root.val <= pre) {
            return false;
        }

        pre = root.val;

        // 右
        if (!helper(root.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_InOrder_Recursion solution_inOrder_recursion = new Solution_InOrder_Recursion();

        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(solution_inOrder_recursion.isValidBST(root));

        root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(7)), new TreeNode(8));
        System.out.println(solution_inOrder_recursion.isValidBST(root));

    }
}

