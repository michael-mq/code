package Algorithm.LeetCode.LeetCode_270_Closest_Binary_Search_Tree_Value;


// https://www.lintcode.com/problem/closest-binary-search-tree-value/description
public class Solution_Recursion_MyOwn {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */

    int result;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return result;
    }

    void helper(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        helper(root.left, target);

        if (root.val == target) {
            result = root.val;
            return;
        } else if (root.val < target) {
            result = root.val;
        } else if (root.val > target) {
            if (Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
                return;
            }
        }

        helper(root.right, target);
    }

    public static void main(String[] args) {
        Solution_Recursion_MyOwn foo = new Solution_Recursion_MyOwn();

        TreeNode root;

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);

        System.out.println(foo.closestValue(root, 6.124780));

        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        System.out.println(foo.closestValue(root, 4.142857));

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(foo.closestValue(root, 2.857143));
    }
}
