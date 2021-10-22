package Algorithm.LeetCode.LeetCode_136_Single_Number;

import java.util.HashSet;
import java.util.Set;

class Solution_Set {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        return set.iterator().next();
    }
}
