package Algorithm.LeetCode.LeetCode_136_Single_Number;

import java.util.HashMap;
import java.util.Map;

public class Solution_Map {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution_Map solutionMap = new Solution_Map();

        long startTime = System.nanoTime();

        System.out.println(solutionMap.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solutionMap.singleNumber(new int[]{4, 1, 2, 1, 2}));

        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }
}
