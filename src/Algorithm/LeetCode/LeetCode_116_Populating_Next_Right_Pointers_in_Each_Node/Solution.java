package Algorithm.LeetCode.LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

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