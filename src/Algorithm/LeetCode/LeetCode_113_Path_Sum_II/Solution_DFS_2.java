package Algorithm.LeetCode.LeetCode_113_Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS_2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, targetSum, result, new ArrayList<>());

        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum)
        {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        dfs(root.left, targetSum - root.val, result, list);
        dfs(root.right, targetSum - root.val, result, list);

        list.remove(list.size() - 1);
    }
}
