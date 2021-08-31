package Algorithm.LeetCode.LeetCode_210_Course_Schedule_II;

import java.util.*;

class Solution_BFS_as_207 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] res = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;

            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            res[index++] = current;

            List<Integer> courses = map.get(current);

            if (courses != null) {
                for (int c : courses) {
                    inDegree[c]--;

                    if (inDegree[c] == 0) {
                        queue.add(c);
                    }
                }
            }
        }

        for (int j : inDegree) {
            if (j != 0)
                return new int[0];
        }

        return res;
    }
}
