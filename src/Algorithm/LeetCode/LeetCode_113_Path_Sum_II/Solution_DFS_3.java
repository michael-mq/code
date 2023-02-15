package Algorithm.LeetCode.LeetCode_113_Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS_3 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return res;
        }
        
        dfs(root, targetSum, list, res);

        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res) {
        list.add(root.val);

        if (root.val == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.val, list, res);
            list.remove(list.size() - 1);
        }
        
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, list, res);
            list.remove(list.size() - 1);
        }      
    }
}