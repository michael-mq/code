package Algorithm.LeetCode.LeetCode_15_3_Sum;

import java.util.*;

// https://leetcode.cn/problems/3sum/solutions/1797615/hashmap-by-dgodu-dwaf/
public class Solution_Map_TimeLimitExceeded {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int n = -(nums[i] + nums[j]);

                if (map.containsKey(n) && map.get(n) > j) { //k>j>i，避免下标重复，减少查询次数
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[map.get(n)]);
                    Collections.sort(list);

                    if (!result.contains(list)) {//避免元组重复
                        result.add(list);

                    }
                }
            }
        }

        return result;
    }
}
