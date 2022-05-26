package Algorithm.LeetCode.LeetCode_314_Binary_Tree_Vertical_Order_Traversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution_MyOwn {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        int row = 0;
        int column = 0;

        dfs(row, column, map, root);

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> _result = new ArrayList<>();
            Map<Integer, List<Integer>> _map = entry.getValue();
            for (Map.Entry<Integer, List<Integer>> _entry : _map.entrySet()) {
                _result.addAll(_entry.getValue());
            }

            result.add(_result);
        }

        return result;
    }

    private void dfs(int row, int column, Map<Integer, Map<Integer, List<Integer>>> map, TreeNode root) {
        if (root == null) {
            return;
        }

        Map<Integer, List<Integer>> innerMap = map.getOrDefault(column, new TreeMap<>());
        List<Integer> list = innerMap.computeIfAbsent(row, key -> new ArrayList<>());
        list.add(root.val);
        map.put(column, innerMap);

        dfs(row + 1, column - 1, map, root.left);
        dfs(row + 1, column + 1, map, root.right);
    }
}
