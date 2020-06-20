package Algorithm.LeetCode.LeetCode_435_NonOverlappingIntervals;

import java.util.Arrays;

public class Greedy {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (int[] a, int[] b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] foo = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };

        int[][] bar = new int[][]{
                {1, 2}, {1, 2}, {1, 2}
        };

        Greedy greedy = new Greedy();

        System.out.println(greedy.eraseOverlapIntervals(foo));
        System.out.println(greedy.eraseOverlapIntervals(bar));
    }
}
