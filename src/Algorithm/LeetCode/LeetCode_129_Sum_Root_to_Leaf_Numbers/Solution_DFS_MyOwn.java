package Algorithm.LeetCode.LeetCode_129_Sum_Root_to_Leaf_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_DFS_MyOwn {
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        List<String> resList = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        int res = 0;

        dfs(root, resList, tmp);

        for (String val : resList) {
            res += Integer.parseInt(val);
        }

        return res;
    }

    private void dfs(TreeNode node, List<String> resList, StringBuilder tmp) {
        tmp.append(node.val);

        if (node.left == null && node.right == null) {
            resList.add(tmp.toString());
        } else {
            if (node.left != null) {
                dfs(node.left, resList, tmp);
            }

            if (node.right != null) {
                dfs(node.right, resList, tmp);
            }
        }

        tmp.setLength(tmp.length() - 1);
    }
}
