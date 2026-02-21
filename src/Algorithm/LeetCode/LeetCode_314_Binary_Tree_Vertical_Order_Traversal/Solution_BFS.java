package Algorithm.LeetCode.LeetCode_314_Binary_Tree_Vertical_Order_Traversal;

import java.util.*;

class Solution_BFS {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0});

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int col = (int) curr[1];

            map.computeIfAbsent(col, k -> new ArrayList<>())
                    .add(node.val);

            if (node.left != null) {
                queue.offer(new Object[]{node.left, col - 1});
            }

            if (node.right != null) {
                queue.offer(new Object[]{node.right, col + 1});
            }
        }

        for (List<Integer> columnResult : map.values()) {

            result.add(columnResult);
        }

        return result;
    }
}