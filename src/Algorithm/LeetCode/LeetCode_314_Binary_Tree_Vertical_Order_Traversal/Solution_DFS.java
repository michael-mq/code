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

class Solution_DFS {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 外层按 Column 排序，内层按 Row 排序
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        // 启动 DFS，初始坐标 (row: 0, col: 0)
        dfs(root, 0, 0, map);

        // 提取结果
        for (Map<Integer, List<Integer>> columnMap : map.values()) {
            List<Integer> columnResult = new ArrayList<>();
            // 由于内层也是 TreeMap，values() 会按 Row 从小到大返回
            for (List<Integer> rowList : columnMap.values()) {
                columnResult.addAll(rowList);
            }
            result.add(columnResult);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (node == null) {
            return;
        }

        // 使用 computeIfAbsent 实现“懒加载”：
        // 只有当这一列没出现过时，才会执行 Lambda 创建新的 TreeMap
        // 这比 putIfAbsent 或 getOrDefault 性能更好，因为不会预先 new 对象
        Map<Integer, List<Integer>> innerMap = map.computeIfAbsent(col, k -> new TreeMap<>());

        // 同样，只有这一行在该列没出现过时，才创建 ArrayList
        List<Integer> list = innerMap.computeIfAbsent(row, k -> new ArrayList<>());

        // 核心：同一行同一列，按先左后右的 DFS 顺序加入 List
        list.add(node.val);

        // 递归：先左后右
        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}
