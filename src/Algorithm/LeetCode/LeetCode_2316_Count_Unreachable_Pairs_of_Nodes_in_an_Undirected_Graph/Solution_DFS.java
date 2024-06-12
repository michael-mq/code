package Algorithm.LeetCode.LeetCode_2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/editorial/#approach-1-depth-first-search
class Solution_DFS {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        long res = 0;
        long remainingNodes = n;
        long sizeOfComponents = 0;
        boolean[] visits = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visits[i]) {
                sizeOfComponents = dfs(i, adj, visits);
                res += sizeOfComponents * (remainingNodes - sizeOfComponents);
                remainingNodes -= sizeOfComponents;
            }
        }

        return res;
    }

    private int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visits) {
        int count = 1;

        visits[node] = true;

        if (!adj.containsKey(node)) {
            return count;
        }

        for (int neighbor : adj.get(node)) {
            if (!visits[neighbor]) {
                count += dfs(neighbor, adj, visits);
            }
        }

        return count;
    }
}