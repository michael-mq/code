package Algorithm.LeetCode.LeetCode_169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

// I don't like it
public class Solution_HashMap_2 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        Solution_HashMap_2 solution_hashMap = new Solution_HashMap_2();

        System.out.println(solution_hashMap.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution_hashMap.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
