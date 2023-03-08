package Algorithm.LeetCode.LeetCode_323_Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/editorial/
class Solution_BFS {
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
                bfs(adjList, visisted, i);
            }
        }

        return components;
    }

    private void bfs(List<Integer>[] adjList, boolean[] visited, int node) {
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int _node = queue.poll();

            for (int i : adjList[_node]) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}