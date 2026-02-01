package Algorithm.LeetCode.LeetCode_114_Flatten_Binary_Tree_to_Linked_List;

//https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/1080708/labuladong-pythonshi-xian-by-christinalu-51oe
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;

        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }
}
