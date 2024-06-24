package Algorithm.LeetCode.LeetCode_210_Course_Schedule_II;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS_as_207 {
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index = numCourses - 1;
        int[] res = new int[numCourses];
        int[] visited = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, edges, res)) {
                return new int[0];
            }
        }

        return res;
    }

    private boolean dfs(int course, int[] visited, List<List<Integer>> edges, int[] res) {
        if (visited[course] == 1) {
            return false;
        }

        if (visited[course] == -1) {
            return true;
        }

        visited[course] = 1;

        for (int i : edges.get(course)) {
            if (!dfs(i, visited, edges, res)) {
                return false;
            }
        }

        visited[course] = -1;
        res[index--] = course;

        return true;
    }
}

