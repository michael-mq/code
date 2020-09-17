package Algorithm.LeetCode.LeetCode_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_MyOwn {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) {
            return intervals;
        }

        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i = 0; i < len - 1; i++) {
            if (intervals[i + 1][0] <= max) {
                max = Math.max(max, intervals[i + 1][1]);
            } else {
                res.add(new int[]{min, max});
                min = intervals[i + 1][0];
                max = intervals[i + 1][1];
            }
        }

        res.add(new int[]{min, max});

        return res.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        Solution_MyOwn foo = new Solution_MyOwn();
        System.out.println(Arrays.deepToString(foo.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));

        System.out.println(Arrays.deepToString(foo.merge(new int[][]{
                {1, 4}, {4, 5}
        })));
    }
}
