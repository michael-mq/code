package Algorithm.LeetCode.LeetCode_111_Minimum_Depth_of_Binary_Tree;

// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/java-di-gui-he-fei-di-gui-liang-chong-fang-shi-de-/

public class Solution_DFS_1 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        //左子树的最小深度
        int left = minDepth(root.left);

        //右子树的最小深度
        int right = minDepth(root.right);

        //如果left和right都为0，我们返回1即可，
        //如果left和right只有一个为0，说明他只有一个子结点，我们只需要返回它另一个子节点的最小深度+1即可。
        //如果left和right都不为0，说明他有两个子节点，我们只需要返回最小深度的+1即可。
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution_DFS_1 foo = new Solution_DFS_1();

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
