package Algorithm.LeetCode.LeetCode_1110_Delete_Nodes_And_Return_Fore;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

class Solution {


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int val : to_delete) {
            set.add(val);
        }

        if (dfs(root, set, res) != null) {
            res.add(root);
        }

        return res;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> res) {
        if (root == null) {
            return null;
        }

        root.left = dfs(root.left, set, res);
        root.right = dfs(root.right, set, res);

        if (set.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }

            if (root.right != null) {
                res.add(root.right);
            }

            return null;
        }

        return root;
    }
}