package Algorithm.LeetCode.LeetCode_270_Closest_Binary_Search_Tree_Value;


// https://www.lintcode.com/problem/closest-binary-search-tree-value/description
public class Solution_Recursion_JiuZhang {
    /**
     * @param root:   the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);

        if (lowerNode == null) {
            return upperNode.val;
        }

        if (upperNode == null) {
            return lowerNode.val;
        }

        if (target - lowerNode.val > upperNode.val - target) {
            return upperNode.val;
        }

        return lowerNode.val;
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
        Solution_Recursion_JiuZhang foo = new Solution_Recursion_JiuZhang();

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
