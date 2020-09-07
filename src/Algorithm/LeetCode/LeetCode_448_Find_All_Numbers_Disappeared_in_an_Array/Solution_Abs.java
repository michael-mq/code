package Algorithm.LeetCode.LeetCode_448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_Abs {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;

            if (nums[j] > 0) {
                nums[j] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Abs solutionMyOwn = new Solution_Abs();

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solutionMyOwn.findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
