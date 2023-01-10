package Algorithm.LeetCode.CN.Offer_27;

class Solution_2 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}