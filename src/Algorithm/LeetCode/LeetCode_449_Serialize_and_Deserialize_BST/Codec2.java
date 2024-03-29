package Algorithm.LeetCode.LeetCode_449_Serialize_and_Deserialize_BST;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val).append(",");

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> q, int lower, int upper) {
        if (q.isEmpty())
            return null;

        String s = q.peek();
        int val = Integer.parseInt(s);

        if (val < lower || val > upper) return null;

        q.poll();
        TreeNode root = new TreeNode(val);

        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);

        return root;
    }
}

// Your Codec.java object will be instantiated and called as such:
// Codec.java ser = new Codec.java();
// Codec.java deser = new Codec.java();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
