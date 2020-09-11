package Algorithm.LeetCode.LeetCode_270_Closest_Binary_Search_Tree_Value;


// https://www.lintcode.com/problem/closest-binary-search-tree-value/description
public class Solution_Recursion1 {
    /**
     * @param root:   the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */

    public int closestValue(TreeNode root, double target) {
        int res = root.val;

        if (target < root.val && root.left != null) {
            int left = closestValue(root.left, target);

            if (Math.abs(res - target) >= Math.abs(left - target)) {
                res = left;
            }
        } else if (target > root.val && root.right != null) {
            int right = closestValue(root.right, target);

            if (Math.abs(res - target) >= Math.abs(right - target)) {
                res = right;
            }
        }

        return res;
    }

    // find the node with the largest value that smaller than target
    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (target <= root.val) {
            return lowerBound(root.left, target);
        }

        // root.val < target
        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }

        return root;
    }

    // find the node with the smallest value that larger than or equal to target
    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (root.val < target) {
            return upperBound(root.right, target);
        }

        // root.val >= target
        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution_Recursion1 foo = new Solution_Recursion1();

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
