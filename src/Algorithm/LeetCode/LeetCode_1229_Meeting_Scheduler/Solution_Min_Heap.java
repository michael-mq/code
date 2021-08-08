package Algorithm.LeetCode.LeetCode_1229_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_Min_Heap {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int len1 = slots1.length;
        int len2 = slots2.length;
        List<Integer> res = new ArrayList<>();

        if (len1 == 0 || len2 == 0)
            return res;

        Comparator<int[]> comparator = (a, b) -> a[0] - b[0];

        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);

        for (int[] slot : slots1)
            if (slot[1] - slot[0] >= duration)
                queue.offer(slot);

        for (int[] slot : slots2)
            if (slot[1] - slot[0] >= duration)
                queue.offer(slot);


        while (queue.size() > 1) {
            int[] pre = queue.poll();
            int[] cur = queue.peek();

            if (pre[1] - cur[0] >= duration) {
                res.add(cur[0]);
                res.add(cur[0] + duration);

                return res;
            }
        }

        return res;
    }
}
