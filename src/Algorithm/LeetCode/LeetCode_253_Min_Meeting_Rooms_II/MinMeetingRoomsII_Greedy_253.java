package Algorithm.LeetCode.LeetCode_253_Min_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MinMeetingRoomsII_Greedy_253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.offer(interval[1]);
        }

        return minHeap.size();
    }
}

class MinMeetingRoomsII_Greedy_253_Main {
    public static void main(String[] args) {
        MinMeetingRoomsII_Greedy_253 foo = new MinMeetingRoomsII_Greedy_253();

        int[][] intervals = {{1, 4}, {2, 8}, {3, 4}, {5, 7}, {5, 9}};

        System.out.println(foo.minMeetingRooms(intervals));
    }
}
