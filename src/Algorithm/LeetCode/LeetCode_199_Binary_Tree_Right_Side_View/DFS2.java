package Algorithm.LeetCode.LeetCode_199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.List;

public class DFS2 {
    private List<Integer> res;
    private int level;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        level = 0;

        dfs(root);

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(root.val);
        } else {
            res.set(level, root.val);
        }

        level++;
        dfs(root.left);
        dfs(root.right);
        level--;
    }
}
