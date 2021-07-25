package Algorithm.LeetCode.LeetCode_337_House_Robber_III;

class Solution_2 {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int rob = root.val + left[0] + right[0];

        int not_rob = Math.max(left[0], left[1]) +
                Math.max(right[0], right[1]);

        return new int[]{not_rob, rob};
    }
}
