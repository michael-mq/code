package Algorithm.LeetCode.LeetCode_136_Single_Number;

import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
class Solution_Set2 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0;

        for (int m : nums) {
            set.add(m);
            sum1 += m;
        }

        int sum2 = 0;

        for (int n : set) {
            sum2 += n;
        }

        return sum2 * 2 - sum1;
    }
}
