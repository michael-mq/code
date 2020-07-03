package Algorithm.LeetCode.LeetCode_102_Binary_Tree_Level_Order_Traversal;

import java.util.*;

public class Solution_DFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        helper(root, 0, result);

        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(root.val);

        if (root.left != null) helper(root.left, level + 1, result);
        if (root.right != null) helper(root.right, level+ 1, result);
    }


    public static void main(String[] args) {
        Solution_DFS foo = new Solution_DFS();

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = foo.levelOrder(root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
