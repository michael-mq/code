package Algorithm.LeetCode.LeetCode_257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

class Solution_Backtracking2 {
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());

        return res;
    }

    private void dfs(TreeNode root, List<String> path) {
        if (root == null) {
            return;
        }

        path.add(Integer.toString(root.val));

        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));

            path.remove(path.size() - 1);
            return;
        }

        dfs(root.left, path);
        dfs(root.right, path);

        path.remove(path.size() - 1);
    }
}