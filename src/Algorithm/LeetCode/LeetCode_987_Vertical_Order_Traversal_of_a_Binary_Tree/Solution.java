package Algorithm.LeetCode.LeetCode_987_Vertical_Order_Traversal_of_a_Binary_Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, 0, 0, map);

        for (TreeMap<Integer, PriorityQueue<Integer>> item : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> queue : item.values()) {
                while (!queue.isEmpty()) {
                    res.get(res.size() - 1).add(queue.poll());
                }
            }
        }

        return res;
    }

    private void dfs(TreeNode root, int x, int y, Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }

        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }

        map.get(x).get(y).offer(root.val);

        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}
