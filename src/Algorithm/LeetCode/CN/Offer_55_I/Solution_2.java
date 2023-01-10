package Algorithm.LeetCode.CN.Offer_55_I;

class Solution_2 {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 0);
        return ans;
    }

    void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        depth++;

        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
        }

        traverse(root.left, depth);
        traverse(root.right, depth);
    }
}