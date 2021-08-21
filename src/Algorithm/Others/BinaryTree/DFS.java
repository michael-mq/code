package Algorithm.Others.BinaryTree;

// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

import java.util.Stack;

public class DFS {
    // Root of Binary Tree
    Node root;

    DFS() {
        root = null;
    }

    /* Given a binary tree, print its nodes in preorder*/

    void printPreOrder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreOrder(node.left);

        /* now recur on right subtree */
        printPreOrder(node.right);
    }

    void printPreOrder_stack(Node node) {
        if (node == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.key + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInOrder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInOrder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInOrder(node.right);
    }

    void printInOrder_stack(Node node) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();

        Node curr = root;

        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();

            System.out.print(curr.key + " ");

            curr = curr.right;
        }
    }

    /* Given a binary tree, print its nodes according to the
"bottom-up" postorder traversal. */
    void printPostOrder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostOrder(node.left);

        // then recur on right subtree
        printPostOrder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    void printPostOrder_stack(Node node) {
        if (node == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        Node prev = root;
        Node current = root;

        while (!stack.isEmpty()) {
            current = stack.peek();

            boolean hasChild = (current.left != null || current.right != null);

            boolean isPrevLastChild = (prev == current.right ||
                    (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                System.out.print(current.key + " ");
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    // Wrappers over above recursive functions
    void printPreOrder() {
        printPreOrder(root);
    }

    void printPreOrder_stack() {
        printPreOrder_stack(root);
    }

    void printInOrder() {
        printInOrder(root);
    }

    void printInOrder_stack() {
        printInOrder_stack(root);
    }

    void printPostOrder() {
        printPostOrder(root);
    }

    void printPostOrder_stack() {
        printPostOrder_stack(root);
    }

    // Driver method
    public static void main(String[] args) {
        DFS tree = new DFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder();
        System.out.println();
        tree.printPreOrder_stack();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder();
        System.out.println();
        tree.printInOrder_stack();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder();
        System.out.println();
        tree.printPostOrder_stack();

        System.out.println();
        System.out.println();

        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(4);
        tree.root.left.left.left = new Node(1);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder();
        System.out.println();
        tree.printPreOrder_stack();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder();
        System.out.println();
        tree.printInOrder_stack();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder();
        System.out.println();
        tree.printPostOrder_stack();
    }
}
