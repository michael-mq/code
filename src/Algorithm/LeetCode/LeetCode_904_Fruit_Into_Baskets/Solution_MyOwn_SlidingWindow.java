package Algorithm.LeetCode.LeetCode_904_Fruit_Into_Baskets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution_MyOwn_SlidingWindow {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 1;

        set.add(fruits[i]);
        map.put(fruits[i], 1);

        int res = 1;
        int n = 1;

        while (j < fruits.length) {
            if (set.size() >= 2 && !set.contains(fruits[j])) {
                while (i < j - 1 && set.size() == 2 && map.get(fruits[i]) > 0) {
                    map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);

                    if (map.get(fruits[i]) == 0) {
                        set.remove(fruits[i]);
                    }
                    n--;
                    i++;
                }
            }

            set.add(fruits[j]);
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            n++;
            res = Math.max(res, n);
            j++;
        }

        return res;
    }
}