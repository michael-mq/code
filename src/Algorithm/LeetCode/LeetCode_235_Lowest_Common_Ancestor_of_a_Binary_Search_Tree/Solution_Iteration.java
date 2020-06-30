package Algorithm.LeetCode.LeetCode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import Algorithm.Others.BinaryTree.Node;

public class Solution_Recursion {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (parentVal > pVal && parentVal > qVal) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (parentVal < pVal && parentVal < qVal) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // this includes one of the node is itself
        return root;
    }

    public static void main(String[] args) {
        Solution_Recursion foo = new Solution_Recursion();

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(foo.lowestCommonAncestor(root, root.left, root.right).val); // 2, 8
        System.out.println(foo.lowestCommonAncestor(root, root.right.left, root.left.right.right).val); // 7, 5
        System.out.println(foo.lowestCommonAncestor(root, root.left, root.left.right).val); // 2, 4
    }
}
