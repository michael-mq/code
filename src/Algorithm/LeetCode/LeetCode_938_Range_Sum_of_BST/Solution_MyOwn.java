package Algorithm.LeetCode.LeetCode_938_Range_Sum_of_BST;


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

public class Solution_MyOwn {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] result = new int[1];

        dfs(root, low, high, result);

        return result[0];

    }

    private void dfs(TreeNode root, int low, int high, int[] result) {
        if (root == null) {
            return;
        }


        dfs(root.left, low, high, result);

        if (root.val >= low && root.val <= high) {
            result[0] += root.val;
        } else if (root.val > high) {
            return;
        }


        dfs(root.right, low, high, result);
    }
}