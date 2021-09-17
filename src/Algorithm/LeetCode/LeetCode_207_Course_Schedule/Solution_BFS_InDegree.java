package Algorithm.LeetCode.LeetCode_207_Course_Schedule;

import java.util.*;

class Solution_BFS_InDegree {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

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

        while (!queue.isEmpty()) {
            int current = queue.poll();
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
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_BFS_InDegree s = new Solution_BFS_InDegree();
        System.out.println(s.canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {1, 3}}));
    }
}
