package Algorithm.LeetCode.CN.Offer_55_I;

class Solution {
    int depth = 0;
    int ans = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return ans;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;

        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
        }

        traverse(root.left);
        traverse(root.right);

        depth--;
    }
}