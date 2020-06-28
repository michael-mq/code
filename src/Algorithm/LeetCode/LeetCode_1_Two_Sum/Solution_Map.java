package Algorithm.LeetCode.LeetCode_1_Two_Sum;

import java.util.*;

public class Solution_Map {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{
                        map.get(temp), i
                };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution_Map foo = new Solution_Map();

        int[] result = foo.twoSum(new int[]{2, 7, 11, 15}, 9);

        System.out.println(Arrays.toString(result));
    }
}
