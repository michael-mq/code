package Algorithm.LeetCode.LeetCode_523_Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution_PreSum_HashMap {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        // (sum1 - sum2) % k = 0
        // so sum1 % k == sum2 % k
        // map(preSum, index)
        Map<Integer, Integer> map = new HashMap<>();
        // if `sum == 0` in the future, line 25 will be true
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Solution_PreSum_HashMap foo = new Solution_PreSum_HashMap();

        System.out.println(foo.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(foo.checkSubarraySum(new int[]{0, 1, 0}, 0));
        System.out.println(foo.checkSubarraySum(new int[]{0}, 0));
    }
}
