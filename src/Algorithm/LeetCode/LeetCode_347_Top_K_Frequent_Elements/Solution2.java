package Algorithm.LeetCode.LeetCode_347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/top-k-frequent-elements/solutions/11201/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int key : map.keySet()) {
            int i = map.get(key);
            list.get(i).add(key);
        }

        int[] result = new int[k];
        int count = 0;

        for (int i = list.size() - 1; i >= 0 && count < k; i--) {
            for (int n : list.get(i)) {
                result[count++] = n;
                if (count > k) {
                    break;
                }
            }
        }

        return result;
    }
}
