package Algorithm.LeetCode.LeetCode_513_Find_Bottom_Left_Tree_Value;

import java.util.LinkedList;
import java.util.Queue;

class Solution_BFS_MyOwn1 {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode leftMost = queue.peek();
            res = leftMost.val;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();

                if (n.left != null) {
                    queue.offer(n.left);
                }

                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
        }

        return res;
    }
}