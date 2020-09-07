package Algorithm.LeetCode.LeetCode_448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

public class Solution_Set_MyOwn {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        List<Integer> result = new LinkedList<Integer>();

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Set_MyOwn solutionMyOwn = new Solution_Set_MyOwn();

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solutionMyOwn.findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
