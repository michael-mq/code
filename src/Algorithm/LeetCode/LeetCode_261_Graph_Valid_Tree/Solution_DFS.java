package Algorithm.LeetCode.LeetCode_261_Graph_Valid_Tree;

import java.util.ArrayList;
import java.util.List;

//https://www.cspiration.com/#/course/video?courseId=26&superType=1&courseName=LeetCode%20题目视频讲解（1-300题分类顺序版）&userCourseId=2534
//For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles. Additionally, if the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, and therefore must be a tree!

class Solution_DFS {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjacent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }

        if (!dfs(0, visited, adjacent, -1)) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, boolean[] visited, List<List<Integer>> adjacent, int parent) {
        if (visited[i]) {
            return false;
        }

        visited[i] = true;

        for (int j : adjacent.get(i)) {
            if (j != parent && !dfs(j, visited, adjacent, i)) {
                return false;
            }
        }

        return true;
    }
}