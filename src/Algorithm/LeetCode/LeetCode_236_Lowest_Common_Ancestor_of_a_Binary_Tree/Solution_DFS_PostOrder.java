package Algorithm.LeetCode.LeetCode_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
// O(n)

class Solution_DFS_PostOrder {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root是top，并且等于p或者q,那么另一个肯定在它的子树下，那么它就是最近公共祖先
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;

        if (left == null) return right;

        if (right == null) return left;

        return root; // 2. if(left != null and right != null)
    }

    public static void main(String[] args) {
        Solution_DFS_PostOrder foo = new Solution_DFS_PostOrder();

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(foo.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(foo.lowestCommonAncestor(root, root.right.left, root.left.right.right).val);
        System.out.println(foo.lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}
