package Algorithm.LeetCode.LeetCode_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_MyOwn4 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(intervals[0][0]);
        list.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > list.get(1)) {
                ans.add(new ArrayList<>(list));
                list.set(0, intervals[i][0]);
                list.set(1, intervals[i][1]);
            } else {
                list.set(0, Math.min(list.get(0), intervals[i][0]));
                list.set(1, Math.max(list.get(1), intervals[i][1]));
            }
        }

        ans.add(new ArrayList<>(list));

        return ans.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}