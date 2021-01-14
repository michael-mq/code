package Algorithm.LeetCode.LeetCode_257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_BFS {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        q1.add(root);
        q2.add(root.val + "");

        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            String path = q2.poll();

            if (node.left == null && node.right == null) {
                res.add(path);
            }

            if (node.left != null) {
                q1.add(node.left);
                q2.add(path + "->" + node.left.val);
            }

            if (node.right != null) {
                q1.add(node.right);
                q2.add(path + "->" + node.right.val);
            }
        }

        return res;
    }
}