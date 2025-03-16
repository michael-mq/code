package Algorithm.LeetCode.LeetCode_904_Fruit_Into_Baskets;

import java.util.HashSet;
import java.util.Set;

class Solution_MyOwn_BruteForce {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1) {
            return 1;
        }

        int res = 0;

        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(fruits[i]);

            int cur = 1;

            for (int j = i + 1; j < fruits.length; j++) {
                set.add(fruits[j]);

                if (set.size() > 2) {
                    break;
                }

                cur++;
                res = Math.max(res, cur);
            }
        }

        return res;
    }
}