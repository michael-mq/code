package Algorithm.LeetCode.LeetCode_257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

class Solution_Backtracking {
    private List<String> result = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {
        backTracking(root, new ArrayList<>());
        return result;
    }

    private void backTracking(TreeNode root, List<Integer> list) {
        list.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i)).append("->");
            }

            sb.append(list.get(list.size() - 1));

            result.add(sb.toString());
            return;
        }

        if (root.left != null) {
            backTracking(root.left, list);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            backTracking(root.right, list);
            list.remove(list.size() - 1);
        }
    }
}