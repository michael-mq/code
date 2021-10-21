package Algorithm.LeetCode.LeetCode_1971_Find_if_Path_Exists_in_Graph;

import java.util.*;

// Using Map, Set to avoid memory limit exceed
class Solution_BFS {
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

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == end) {
                return true;
            }

            visited.add(cur);

            for (int next : graph.get(cur)) {
                if (!visited.contains(next)) {
                    queue.add(next);
                }
            }
        }

        return false;
    }
}
