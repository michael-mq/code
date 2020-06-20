package Algorithm.LeetCode.LeetCode_169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap_1 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);

            if (map.get(nums[i]) > len / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_HashMap_1 solution_hashMap = new Solution_HashMap_1();

        System.out.println(solution_hashMap.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution_hashMap.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
