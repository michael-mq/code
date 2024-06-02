package Algorithm.LeetCode.LeetCode_939_Minimum_Area_Rectangle;

import java.util.*;

// https://leetcode.cn/problems/minimum-area-rectangle/solutions/15996/zui-xiao-mian-ji-ju-xing-by-leetcode
class Solution2 {
    public int minAreaRect(int[][] points) {
        int ans = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int[] point : points) {
            set.add(40001 * point[0] + point[1]);
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]
                        && set.contains(40001 * points[i][0] + points[j][1])
                        && set.contains(40001 * points[j][0] + points[i][1])) {
                    int area = (Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                    ans = Math.min(ans, area);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
