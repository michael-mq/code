package Algorithm.LeetCode.LeetCode_257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

class Solution_Recursive {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null)
            return res;

        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }

        for (String path : binaryTreePaths(root.left)) {
            res.add(root.val + "->" + path);
        }

        for (String path : binaryTreePaths(root.right)) {
            res.add(root.val + "->" + path);
        }

        return res;
    }
}