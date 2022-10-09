package Algorithm.LeetCode.LeetCode_398_Random_Pick_Index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_MyOwn {
    private Map<Integer, List<Integer>> map1;
    private Map<Integer, Integer> map2;

    public Solution_MyOwn(int[] nums) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map1.computeIfAbsent(nums[i], x -> new ArrayList<>());
            list.add(i);
            map2.put(nums[i], 0);
        }
    }

    public int pick(int target) {
        List<Integer> list = map1.get(target);
        int len = list.size();

        if (len == 1) {
            return list.get(0);
        }

        int count = map2.get(target);
        int res = list.get(count % list.size());
        map2.put(target, ++count);

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */