package Algorithm.LeetCode.LeetCode_111_Minimum_Depth_of_Binary_Tree;

// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/java-di-gui-he-fei-di-gui-liang-chong-fang-shi-de-/

public class Solution_DFS_2 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution_DFS_2 foo = new Solution_DFS_2();

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(foo.minDepth(root));

        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(4), null)));
        System.out.println(foo.minDepth(root));

        root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(foo.minDepth(root));
    }
}
