package Algorithm.LeetCode.LeetCode_450_Delete_Node_in_a_BST;


// https://www.programmercarl.com/0450.删除二叉搜索树中的节点.html
public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) return root;
        if (root == null) return null;

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
//                root = root.right;
                return root.right; // my way
            }
        }

        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);

        return root;
    }
}
