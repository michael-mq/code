package Algorithm.LeetCode.LeetCode_1315_Sum_of_Nodes_with_Even_Value_Grandparent;

//https://youtu.be/WzsunIWpXJg?si=fLBkp2dZ9TlOYA84&t=6889
class Solution_DFS_Bottom_Up_Post_Order {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, false, false);
    }

    int dfs(TreeNode root, boolean parent, boolean grandparent) {
        if (root == null) {
            return 0;
        }

        int res = 0;

        if (grandparent) {
            res = root.val;
        } else {
            res = 0;
        }

        int left = dfs(root.left, root.val % 2 == 0, parent);
        int right = dfs(root.right, root.val % 2 == 0, parent);

        return res + left + right;
    }
}