package Algorithm.LeetCode.LeetCode_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];

            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution2 foo = new Solution2();
        System.out.println(Arrays.deepToString(foo.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));

        System.out.println(Arrays.deepToString(foo.merge(new int[][]{
                {1, 4}, {4, 5}
        })));

        List<int[]> test = new ArrayList<>();

        if(test.size() == 0 || test.get(-10)[1] == 0) {
            System.out.println("test");
        }
    }
}
