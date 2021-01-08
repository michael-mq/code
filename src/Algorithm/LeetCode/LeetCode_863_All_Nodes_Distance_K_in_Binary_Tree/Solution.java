package Algorithm.LeetCode.LeetCode_863_All_Nodes_Distance_K_in_Binary_Tree;

import java.util.*;

class Solution {
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();

        if (K < 0) return res;

        buildGraph(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        while (!q.isEmpty()) {
            int size = q.size();

            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    res.add(cur.val);
                }

                return res;
            }

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                for (TreeNode neighbour : graph.get(cur)) {
                    if (visited.contains(neighbour)) continue;

                    q.offer(neighbour);
                    visited.add(neighbour);
                }
            }

            K--;
        }

        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) return;

        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList());

            if (parent != null ){
                graph.get(node).add(parent);
                graph.get(parent).add(node);
            }

            buildGraph(node.left, node);
            buildGraph(node.right, node);

        }
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        TreeNode root;

        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(foo.distanceK(root, root.left, 2).toString());
    }
}
