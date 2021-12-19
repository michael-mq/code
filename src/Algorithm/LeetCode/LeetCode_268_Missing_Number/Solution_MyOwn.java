package Algorithm.LeetCode.LeetCode_268_Missing_Number;

import java.util.HashSet;
import java.util.Set;

class Solution_MyOwn {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }
}
