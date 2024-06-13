package Algorithm.LeetCode.LeetCode_797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS2 {
    private List<List<Integer>> res;
    private List<Integer> path;
    private int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        this.graph = graph;

        path.add(0);
        dfs(0);

        return res;
    }

    private void dfs(int i) {
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(path));

            return;
        }

        for (int j : graph[i]) {
            path.add(j);
            dfs(j);
            path.remove(path.size() - 1);
        }
    }
}