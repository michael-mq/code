package Algorithm.LeetCode.LeetCode_429_N_ary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                level.add(node.val);

                for (Node child : node.children) {
                    queue.offer(child);
                }
            }

            result.add(level);
        }

        return result;
    }
}