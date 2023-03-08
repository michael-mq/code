package Algorithm.LeetCode.LeetCode_323_Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/editorial/
class Solution_DFS {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        boolean[] visisted = new boolean[n];

        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] nodes : edges) {
            adjList[nodes[0]].add(nodes[1]);
            adjList[nodes[1]].add(nodes[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visisted[i]) {
                components++;
                dfs(adjList, visisted, i);
            }
        }

        return components;
    }

    private void dfs(List<Integer>[] adjList, boolean[] visited, int startNode) {
        visited[startNode] = true;

        for (int i : adjList[startNode]) {
            if (!visited[i]) {
                dfs(adjList, visited, i);
            }
        }
    }
}