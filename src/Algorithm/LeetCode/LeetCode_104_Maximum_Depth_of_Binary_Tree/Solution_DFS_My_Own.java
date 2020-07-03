package Algorithm.LeetCode.LeetCode_104_Maximum_Depth_of_Binary_Tree;

public class Solution_DFS_My_Own {
    public int maxDepth(TreeNode root) {
        int depth = 0;

        if (root == null) return depth;

        int maxDepth = helper(root, 0);

        return maxDepth + 1;
    }

    private int helper(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }

        int left = depth, right = depth;

        if (root.left != null) {
            left = helper(root.left, depth + 1);
        }
        if (root.right != null) {
            right = helper(root.right, depth + 1);
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution_DFS_My_Own foo = new Solution_DFS_My_Own();

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(foo.maxDepth(root));

        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(4), null)));
        System.out.println(foo.maxDepth(root));
    }

}
