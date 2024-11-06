package Algorithm.LeetCode.LeetCode_366_Find_Leaves_of_Binary_Tree;

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

// https://www.youtube.com/watch?v=f072MAkKaNo
// https://leetcode.com/problems/find-leaves-of-binary-tree/editorial/#approach-2-dfs-depth-first-search-without-sorting
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);

        return res;
    }

    private int height(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }

        int level = 1 + Math.max(height(root.left, res), height(root.right, res));

        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        return level;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root;

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        solution.findLeaves(root);
    }
}
