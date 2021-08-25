package Algorithm.LeetCode.LeetCode_1120_Maximum_Average_Subtree;


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

class Solution_MyOwn {
    double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);

        return max;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // important of using double / double!!
        max = Math.max(max, (double) (left[0] + right[0] + root.val) / (double) (left[1] + right[1] + 1));

        return new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
    }
}
