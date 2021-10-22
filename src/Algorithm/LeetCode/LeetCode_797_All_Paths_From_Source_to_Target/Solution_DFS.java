package Algorithm.LeetCode.LeetCode_797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution_DFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(graph, 0, result, new LinkedList<>());

        return result;
    }

    private void dfs(int[][] graph, int index, List<List<Integer>> result, LinkedList<Integer> path) {
        path.add(index);

        if (index == graph.length - 1) {
            result.add(new LinkedList<>(path));

            return;
        }

        for (int n : graph[index]) {
            dfs(graph, n, result, path);
            path.removeLast();
        }
    }
}
