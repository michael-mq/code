package Algorithm.LeetCode.LeetCode_448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

public class Solution_HashMap {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // Hash table for keeping track of the numbers in the array
        // Note that we can also use a set here since we are not
        // really concerned with the frequency of numbers.
        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();

        // Add each of the numbers to the hash table
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], true);
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that don't appear in the hash table.
        for (int i = 1; i <= nums.length; i++) {
            if (!hashTable.containsKey(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_HashMap solutionMyOwn = new Solution_HashMap();

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solutionMyOwn.findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
