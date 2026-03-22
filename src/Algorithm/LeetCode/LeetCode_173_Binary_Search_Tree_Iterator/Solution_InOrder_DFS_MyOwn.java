package Algorithm.LeetCode.LeetCode_173_Binary_Search_Tree_Iterator;

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
class Solution_InOrder_DFS_MyOwn {
    class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    Node pointer;
    Node head;

    public Solution_InOrder_DFS_MyOwn(TreeNode root) {
        pointer = new Node(-1);
        head = new Node();
        head.next = pointer;

        dfs(root);

        pointer = head.next;
    }

    public int next() {
        int val = pointer.next.val;
        pointer = pointer.next;
        return val;
    }

    public boolean hasNext() {
        return pointer.next != null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Node node = new Node(root.val);

        dfs(root.left);

        pointer.next = node;
        pointer = node;

        dfs(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */