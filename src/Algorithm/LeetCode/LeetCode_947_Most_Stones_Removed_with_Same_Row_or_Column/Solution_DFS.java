package Algorithm.LeetCode.LeetCode_947_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/editorial
class Solution_DFS {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int connectedStones = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adjacencyList, i, visited);
                connectedStones++;
            }
        }

        return n - connectedStones;
    }

    private void dfs(List<List<Integer>> adjacencyList, int index, boolean[] visited) {
        visited[index] = true;

        for (int neighbour : adjacencyList.get(index)) {
            if (!visited[neighbour]) {
                dfs(adjacencyList, neighbour, visited);
            }
        }
    }
}