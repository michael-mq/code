package Algorithm.Others.BinaryTree;

// Recursive Java program for level order traversal of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void levelOrderQueue(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.println(node.key);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        BFS bfs = new BFS();

        System.out.println("Breadth First Search : ");

        bfs.levelOrderQueue(root);
    }
}

