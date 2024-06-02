package Algorithm.LeetCode.LeetCode_939_Minimum_Area_Rectangle;

import java.util.*;

// https://leetcode.cn/problems/minimum-area-rectangle/solutions/15996/zui-xiao-mian-ji-ju-xing-by-leetcode
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();

        for (int[] point : points) {
            int x = point[0], y = point[1];
            rows.computeIfAbsent(x, z -> new ArrayList<>()).add(y);
        }

        Map<Integer, Integer> lastX = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int x : rows.keySet()) {
            List<Integer> row = rows.get(x);
            Collections.sort(row);

            for (int i = 0; i < row.size(); i++) {
                for (int j = i + 1; j < row.size(); j++) {
                    int y1 = row.get(i), y2 = row.get(j);
                    int code = y1 * 40001 + y2;

                    if (lastX.containsKey(code)) {
                        int area = (x - lastX.get(code)) * (y2 - y1);
                        ans = Math.min(ans, area);
                    }

                    lastX.put(code, x);
                }
            }
        }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
