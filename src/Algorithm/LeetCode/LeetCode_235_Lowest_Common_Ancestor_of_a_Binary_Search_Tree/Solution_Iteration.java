package Algorithm.LeetCode.LeetCode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

public class Solution_Iteration {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                // this includes one of the node is itself
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution_Iteration foo = new Solution_Iteration();

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
