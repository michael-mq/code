package Algorithm.LeetCode.LeetCode_797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_BFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        Queue<LinkedList<Integer>> queue = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        queue.add(path);

        while (!queue.isEmpty()) {
            LinkedList<Integer> currentPath = queue.poll();
            int node = currentPath.getLast();

            for (int nextNode : graph[node]) {
                LinkedList<Integer> tmpPath = new LinkedList<>(currentPath);
                tmpPath.add(nextNode);

                if (nextNode == graph.length - 1) {
                    paths.add(new LinkedList<>(tmpPath));
                } else {
                    queue.add(new LinkedList<>(tmpPath));
                }
            }

        }

        return paths;
    }
}
