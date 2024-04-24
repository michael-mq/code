package Algorithm.LeetCode.LeetCode_112_Path_Sum;


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

class Solution_DFS {
    boolean res;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);

        return res;
    }

    private void dfs(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }

        sum += root.val;

        if (root.left == null && root.right == null && sum == targetSum) {
            res = true;
        }

        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
    }
}
