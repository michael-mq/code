package Algorithm.LeetCode.LeetCode_18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.programmercarl.com/0018.四数之和.html
class Solution_Sort_Two_Pointer {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target)
                return result;

            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;

                int right = nums.length - 1;
                int left = j + 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left + 1] == nums[left])
                            left++;

                        while (left < right && nums[right - 1] == nums[right])
                            right--;

                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    }
}