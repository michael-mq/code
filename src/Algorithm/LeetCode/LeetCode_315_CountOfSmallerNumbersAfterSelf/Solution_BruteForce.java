package Algorithm.LeetCode.LeetCode_315_CountOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_BruteForce {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return null;
        }

        int len = nums.length;

        if (len == 0) {
            return new ArrayList<>();
        }

        if (len == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BruteForce solution_bruteForce = new Solution_BruteForce();

        System.out.println(solution_bruteForce.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
