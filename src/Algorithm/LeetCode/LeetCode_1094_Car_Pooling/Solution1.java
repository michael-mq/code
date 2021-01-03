package Algorithm.LeetCode.LeetCode_1094_Car_Pooling;

import java.util.Map;
import java.util.TreeMap;

class Solution1 {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] t : trips) {
            map.put(t[1], map.getOrDefault(t[1], 0) + t[0]); //上车加
            map.put(t[2], map.getOrDefault(t[2], 0) - t[0]); //下车减
        }

        for (int value : map.values()) {
            capacity -= value;
            if (capacity < 0) return false;
        }

        return true;
    }
}
