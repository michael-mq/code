package Algorithm.LeetCode.LeetCode_797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_BFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();

        path.add(0);
        queue.add(path);

        while (!queue.isEmpty()) {
            List<Integer> curPath = queue.poll();
            int i = curPath.get(curPath.size() - 1);

            for (int j : graph[i]) {
                List<Integer> tmpPath = new ArrayList<>(curPath);
                tmpPath.add(j);

                if (j == graph.length - 1) {
                    res.add(new ArrayList<>(tmpPath));
                } else {
                    queue.add(new ArrayList<>(tmpPath));
                }
            }
        }

        return res;
    }
}
