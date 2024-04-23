package Algorithm.LeetCode.LeetCode_513_Find_Bottom_Left_Tree_Value;

class Solution_DFS_MyOwn1 {
    private int res = 0;
    private int maxLevel = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);

        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        level++;

        if (maxLevel < level) {
            maxLevel = level;
            res = root.val;
        }

        dfs(root.left, level);
        dfs(root.right, level);
    }
}