package Algorithm.LeetCode.LeetCode_1644_Lowest_Common_Ancestor_of_a_Binary_Tree_II;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.
// Keep traversing down the entire tree. If you return early, the above example would be null, because the code stops when it finds 5 and does not keep searching for 4.
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int[] counter = new int[1];
        TreeNode result = _lowestCommonAncestor(root, p, q, counter);

        if (counter[0] != 2) {
            return null;
        }

        return result;
    }

    private TreeNode _lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, int[] counter) {
        if (root == null) {
            return root;
        }

        TreeNode left = _lowestCommonAncestor(root.left, p, q, counter);
        TreeNode right = _lowestCommonAncestor(root.right, p, q, counter);

        if (root == p || root == q) {
            counter[0]++;
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}