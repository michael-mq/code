package Algorithm.LeetCode.LeetCode_111_Minimum_Depth_of_Binary_Tree;

// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/java-di-gui-he-fei-di-gui-liang-chong-fang-shi-de-/

import java.util.LinkedList;
import java.util.Queue;

public class Solution_BFS {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            depth++;

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        Solution_BFS foo = new Solution_BFS();

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
