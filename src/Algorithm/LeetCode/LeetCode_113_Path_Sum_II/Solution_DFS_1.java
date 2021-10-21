package Algorithm.LeetCode.LeetCode_113_Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS_1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, targetSum, new ArrayList<>(), res);

        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> tmp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        tmp.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(tmp));
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.val, tmp, res);
            tmp.remove(tmp.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, targetSum - root.val, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
