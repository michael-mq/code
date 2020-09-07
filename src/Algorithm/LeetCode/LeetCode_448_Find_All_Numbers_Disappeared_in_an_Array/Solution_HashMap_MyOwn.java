package Algorithm.LeetCode.LeetCode_448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

public class Solution_HashMap_MyOwn {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        if (nums == null || n == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.get(nums[i]) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_HashMap_MyOwn solutionMyOwn = new Solution_HashMap_MyOwn();

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solutionMyOwn.findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
