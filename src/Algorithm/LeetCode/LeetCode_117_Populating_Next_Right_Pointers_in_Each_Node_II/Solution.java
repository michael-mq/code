package Algorithm.LeetCode.LeetCode_117_Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node next = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                current.next = next;
                next = current;

                if (current.right != null)
                    queue.offer(current.right);

                if (current.left != null)
                    queue.offer(current.left);
            }
        }

        return root;
    }
}