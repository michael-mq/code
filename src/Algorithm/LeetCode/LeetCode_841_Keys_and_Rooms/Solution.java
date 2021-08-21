package Algorithm.LeetCode.LeetCode_841_Keys_and_Rooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visited = new boolean[size];

//        dfs(rooms, 0, visited);
        bfs(rooms, visited);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int n, boolean[] visited) {
        visited[n] = true;

        List<Integer> _rooms = rooms.get(n);

        for (int i = 0; i < _rooms.size(); i++) {
            if (!visited[_rooms.get(i)]) {
                dfs(rooms, _rooms.get(i), visited);
            }
        }
    }

    private void bfs(List<List<Integer>> rooms, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            List<Integer> _rooms = rooms.get(n);

            for (int i = 0; i < _rooms.size(); i++) {
                if (!visited[_rooms.get(i)]) {
                    queue.offer(_rooms.get(i));
                    visited[_rooms.get(i)] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(solution.canVisitAllRooms(rooms));
    }
}
