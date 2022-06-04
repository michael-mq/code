package Algorithm.LeetCode.LeetCode_791_Custom_Sort_String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution_MyOwn {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new PriorityQueue<>((a, b) -> {
            int i = map.get(a) == null ? -1 : map.get(a);
            int j = map.get(b) == null ? -1 : map.get(b);
            return i - j;
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        int size = queue.size();

        for (int i = 0; i < size; i++) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}