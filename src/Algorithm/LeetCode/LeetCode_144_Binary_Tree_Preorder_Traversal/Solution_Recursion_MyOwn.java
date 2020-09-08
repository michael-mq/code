package Algorithm.LeetCode.LeetCode_144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution_Recursion_MyOwn {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        helper(res, root);

        return res;
    }

    void helper(List<Integer> res, TreeNode root) {
        if (root != null) {
            res.add(root.val);
            helper(res, root.left);
            helper(res, root.right);
        }
    }
}
