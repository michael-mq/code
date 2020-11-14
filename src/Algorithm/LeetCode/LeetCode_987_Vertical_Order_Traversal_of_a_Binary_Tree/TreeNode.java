package Algorithm.LeetCode.LeetCode_987_Vertical_Order_Traversal_of_a_Binary_Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this(val, null, null);
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
