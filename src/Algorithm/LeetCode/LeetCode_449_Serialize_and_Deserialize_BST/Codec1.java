package Algorithm.LeetCode.LeetCode_449_Serialize_and_Deserialize_BST;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec1 {
    // Encodes a tree to a single string.
    //BST的前序遍历结果
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        //拼接当前节点
        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        return builder(arr, 0, arr.length - 1);
    }

    private TreeNode builder(String[] arr, int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[lo]));
        //找到第一个比首元素大的元素位置
        int index = hi + 1;
        for (int i = lo + 1; i <= hi; i++) {
            if (Integer.valueOf(arr[i]) > root.val) {
                index = i;
                break;
            }
        }
        //递归构建子树
        root.left = builder(arr, lo + 1, index - 1);
        root.right = builder(arr, index, hi);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
