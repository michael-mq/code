package Algorithm.LeetCode.LeetCode_104_Maximum_Depth_of_Binary_Tree;

public class Solution_DFS {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution_DFS foo = new Solution_DFS();

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(foo.maxDepth(root));

        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(4), null)));
        System.out.println(foo.maxDepth(root));
    }

}
