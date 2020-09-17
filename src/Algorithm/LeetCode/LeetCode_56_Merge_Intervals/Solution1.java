package Algorithm.LeetCode.LeetCode_56_Merge_Intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution1 {
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

    public static void main(String[] args) {
        Solution1 foo = new Solution1();
        System.out.println(Arrays.deepToString(foo.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));

        System.out.println(Arrays.deepToString(foo.merge(new int[][]{
                {1, 4}, {4, 5}
        })));
    }
}
