package Algorithm.LeetCode.LeetCode_113_Path_Sum_II;

import java.util.ArrayList;
import java.util.List;


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, 0, targetSum, new ArrayList<>(), res);

        return res;
    }

    public void dfs(TreeNode root, int sum, int targetSum, List<Integer> tmp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        tmp.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(tmp));
        }

        if (root.left != null) {
            dfs(root.left, sum, targetSum, tmp, res);
            tmp.remove(tmp.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, sum, targetSum, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
