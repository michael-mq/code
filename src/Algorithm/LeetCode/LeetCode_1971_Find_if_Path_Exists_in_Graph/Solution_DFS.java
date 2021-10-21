package Algorithm.LeetCode.LeetCode_1971_Find_if_Path_Exists_in_Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Using Map, Set to avoid memory limit exceed
class Solution_DFS {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) {
            return true;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (edge[0] == start && edge[1] == end || edge[1] == start && edge[0] == end) {
                return true;
            }

            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(n, graph, start, end, visited);
    }

    private boolean dfs(int n, Map<Integer, Set<Integer>> graph, int start, int end, Set<Integer> visited) {
        if (start == end) {
            return true;
        }

        visited.add(start);

        for (int i : graph.get(start)) {
            if (!visited.contains(i)) {
                if (dfs(n, graph, i, end, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
