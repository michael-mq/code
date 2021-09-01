package Algorithm.LeetCode.LeetCode_207_Course_Schedule;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS {
    int[] visited;
    boolean valid;
    List<List<Integer>> edges;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }

            if (!valid) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int u) {
        visited[u] = 1;

        for(int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);

                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;

                return;
            }
        }

        visited[u] = 2;
    }
}
