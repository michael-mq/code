package Algorithm.LeetCode.LeetCode_2013_Detect_Squares;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/detect-squares/solution/dai-ma-jie-de-xiao-bai-shi-yong-hashtu-j-4ww5/
class DetectSquares {
    Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0];
        int y = point[1];

        if (!map.containsKey(x)) {
            return res;
        }

        Map<Integer, Integer> yMap = map.get(x);

        for (int col : map.keySet()) {
            Map<Integer, Integer> colMap = map.get(col);

            if (col != x) {
                int d = col - x;
                res += colMap.getOrDefault(y, 0) * yMap.getOrDefault(y + d, 0) * colMap.getOrDefault(y + d, 0);
                res += colMap.getOrDefault(y, 0) * yMap.getOrDefault(y - d, 0) * colMap.getOrDefault(y - d, 0);
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