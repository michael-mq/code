package Algorithm.LeetCode.LeetCode_253_Min_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;

class MinMeetingRoomsII_Greedy_253 {
    int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.add(intervals[i][1]);
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
