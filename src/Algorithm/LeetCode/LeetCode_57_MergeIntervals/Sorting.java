package Algorithm.LeetCode.LeetCode_57_MergeIntervals;

import java.util.*;

public class Sorting {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        LinkedList<int[]> result = new LinkedList<>();

        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastArray = result.getLast();

            if (lastArray[1] >= intervals[i][0]) {
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}

class Main {
    public static void main(String[] args) {
        Sorting sorting = new Sorting();

        int[][] foo = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        int[][] bar = sorting.merge(foo);
        System.out.println(Arrays.deepToString(bar));
    }
}
