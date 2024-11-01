package Algorithm.LeetCode.LeetCode_1448_Count_Good_Nodes_in_Binary_Tree;


class Solution_MyOwn {
    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);

        return res;
    }

    void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            max = root.val;
            res++;
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }
}