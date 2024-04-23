package Algorithm.LeetCode.LeetCode_513_Find_Bottom_Left_Tree_Value;


import java.util.ArrayList;
import java.util.List;

public class Solution_DFS_MyOwn {
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, 0, res);

        return res.get(res.size() - 1).get(0);
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }

        List<Integer> list = res.get(level);
        list.add(root.val);

        if (root.left != null) {
            dfs(root.left, level + 1, res);
        }

        if (root.right != null) {
            dfs(root.right, level + 1, res);
        }
    }
}
