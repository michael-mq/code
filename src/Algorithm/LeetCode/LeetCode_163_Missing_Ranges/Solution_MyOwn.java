package Algorithm.LeetCode.LeetCode_163_Missing_Ranges;

import java.util.ArrayList;
import java.util.List;

class Solution_MyOwn {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            if (lower != upper) {
                res.add(lower + "->" + upper);
            } else {
                res.add(String.valueOf(lower));
            }
        } else {
            if (nums[0] >= lower + 2) {
                res.add(lower + "->" + (nums[0] - 1));
            } else if (nums[0] == lower + 1) {
                res.add(String.valueOf(lower));
            }

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1] + 2) {
                    res.add(String.valueOf(nums[i - 1] + 1));
                } else if (nums[i] > nums[i - 1] + 2) {
                    res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
                }
            }

            if (nums[nums.length - 1] <= upper - 2) {
                res.add((nums[nums.length - 1] + 1) + "->" + upper);
            } else if (nums[nums.length - 1] == upper - 1) {
                res.add(String.valueOf(upper));
            }
        }

        return res;
    }
}
