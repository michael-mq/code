package Algorithm.LeetCode.LeetCode_15_3_Sum;

import java.util.*;

public class Solution_Map_MyOwn_TimeLimitExceeded {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int total = nums[i] + nums[j];
                List<List<Integer>> list = map.computeIfAbsent(total, n -> new ArrayList<>());
                List<Integer> _list = new ArrayList<>();
                _list.add(i);
                _list.add(j);
                list.add(_list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int n = -nums[i];

            if (map.containsKey(n)) {
                List<List<Integer>> list = map.get(n);

                for (List<Integer> l : list) {
                    if (!l.contains(i)) {
                        l.add(i);
                        List<Integer> sorted = new ArrayList<>();
                        sorted.add((nums[l.get(0)]));
                        sorted.add((nums[l.get(1)]));
                        sorted.add((nums[l.get(2)]));

                        Collections.sort(sorted);

                        if (!result.contains(sorted)) {
                            result.add(sorted);
                        }
                    }
                }
            }
        }

        return result;
    }
}


