package Algorithm.LeetCode.LeetCode_98_ValidateBinarySearchTree;

public class Solution_Recursion {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        // inherit min from parent
        if (!helper(root.left, min, root.val)) {
            return false;
        }

        // inherit max from parent
        if (!helper(root.right, root.val, max)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Recursion solution_recursion = new Solution_Recursion();

        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(solution_recursion.isValidBST(root));

        root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(7)), new TreeNode(8));
        System.out.println(solution_recursion.isValidBST(root));

    }
}

