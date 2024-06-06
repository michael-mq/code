package Algorithm.LeetCode.LeetCode_2013_Detect_Squares;

import java.util.HashMap;
import java.util.Map;

// 对角线解法，对我自己来说，容易理解
// https://leetcode.cn/problems/minimum-area-rectangle/solutions/15996/zui-xiao-mian-ji-ju-xing-by-leetcode
class DetectSquares_MyOwn {
    private final Map<Integer, int[]> map;

    public DetectSquares_MyOwn() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int hash = 1001 * point[0] + point[1];
        int[] v = map.computeIfAbsent(hash, i -> new int[3]);
        v[0] = point[0];
        v[1] = point[1];
        v[2] += 1;
    }

    public int count(int[] point) {
        int res = 0;

        for (int key : map.keySet()) {
            int[] v = map.get(key);

            int k1 = 1001 * v[0] + point[1];
            int k2 = 1001 * point[0] + v[1];

            int[] v1 = map.get(k1);
            int[] v2 = map.get(k2);

            if (v1 != null && v2 != null &&
                    Math.abs(v[0] - v2[0]) == Math.abs(v[1] - v1[1]) &&
                    Math.abs(v[0] - v2[0]) * Math.abs(v[1] - v1[1]) > 0
            ) {
                res += v[2] * v1[2] * v2[2];
            }
        }

        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */