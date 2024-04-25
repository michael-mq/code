package Algorithm.LeetCode.LeetCode_98_Validate_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution_InOrder_Recursion_MyOwn {
    public boolean isValidBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        dfs(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val <= list.get(i - 1).val) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        Solution_InOrder_Recursion_MyOwn solution_inOrder_recursion = new Solution_InOrder_Recursion_MyOwn();

        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(solution_inOrder_recursion.isValidBST(root));

        root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(7)), new TreeNode(8));
        System.out.println(solution_inOrder_recursion.isValidBST(root));

    }
}

