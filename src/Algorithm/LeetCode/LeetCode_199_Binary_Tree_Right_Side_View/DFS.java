package Algorithm.LeetCode.LeetCode_199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root, 0, res);

        return res;
    }

    void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 先访问 当前节点，再递归地访问 右子树 和 左子树
        if (depth == res.size()) { // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }

        depth++;

        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }
}
