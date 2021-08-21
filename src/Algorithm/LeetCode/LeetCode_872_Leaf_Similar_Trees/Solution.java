package Algorithm.LeetCode.LeetCode_872_Leaf_Similar_Trees;

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

// Normal BFS will not work because the leafs might not be in the same LEVEL!!
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);

            return;
        }

        if (root.left != null) {
            dfs(root.left, list);
        }

        if (root.right != null) {
            dfs(root.right, list);
        }
    }
}
