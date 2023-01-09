package Algorithm.LeetCode.LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution_BFS_2 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Deque<Node> dq = new LinkedList<>();
        dq.addLast(root);

        while (!dq.isEmpty()) {
            int n = dq.size();
            Node tmp = null;

            for (int i = 0; i < n; i++) {
                Node node = dq.pollLast();
                node.next = tmp;
                tmp = node;

                if (node.right != null) {
                    dq.addFirst(node.right);
                }

                if (node.left != null) {
                    dq.addFirst(node.left);
                }
            }
        }

        return root;
    }
}
