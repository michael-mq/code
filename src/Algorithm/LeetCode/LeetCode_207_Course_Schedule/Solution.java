package Algorithm.LeetCode.LeetCode_207_Course_Schedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;

            if (graph.containsKey(prerequisites[i][1])) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> toTake = graph.get(cur);

            for (int i = 0; toTake != null && i < toTake.size(); i++) {
                inDegree[toTake.get(i)]--;

                if (inDegree[toTake.get(i)] == 0)
                    queue.add(toTake.get(i));
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0)
                return false;
        }

        return true;
    }
}
