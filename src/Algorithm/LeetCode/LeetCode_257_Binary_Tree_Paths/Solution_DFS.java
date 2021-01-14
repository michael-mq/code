package Algorithm.LeetCode.LeetCode_257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null)
            return res;

        helper(root, "", res);

        return res;
    }

    private void helper(TreeNode root, String path, List<String> res) {
        if (root == null)
            return;

        path += root.val;

        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }

        helper(root.left, path + "->", res);
        helper(root.right, path + "->", res);
    }
}