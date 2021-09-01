package Algorithm.LeetCode.LeetCode_207_Course_Schedule;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, edges)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, int[] visited, List<List<Integer>> edges) {
        if (visited[i] == 1) {
            return false;
        }

        if (visited[i] == -1) {
            return true;
        }

        visited[i] = 1;

        for(int j: edges.get(i)) {
            if (!dfs(j, visited, edges)) {
                return false;
            }
        }

        visited[i] = -1;

        return true;
    }
}
