package Algorithm.LeetCode.LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution_BFS {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node currNode = queue.poll();

            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }

            for (int i = 1; i < size; i++) {
                Node nextNode = queue.poll();

                if (nextNode.left != null) {
                    queue.add(nextNode.left);
                }

                if (nextNode.right != null) {
                    queue.add(nextNode.right);
                }

                currNode.next = nextNode;
                currNode = nextNode;
            }
        }

        return root;
    }
}
