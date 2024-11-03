package Algorithm.LeetCode.LeetCode_1302_Deepest_Leaves_Sum;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_BFS {
    public int deepestLeavesSum(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while (!q.isEmpty()) {
            res = 0;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                res += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return res;
    }
}