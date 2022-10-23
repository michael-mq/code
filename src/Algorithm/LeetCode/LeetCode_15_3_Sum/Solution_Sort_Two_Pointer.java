package Algorithm.LeetCode.LeetCode_15_3_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_Sort_Two_Pointer {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];

            int low = i + 1;
            int high = nums.length - 1;

            // unless it's the first element, move forward if current number is same as previous number
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        results.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // move forward if next number is same as previous number
                        while (low < high && nums[low + 1] == nums[low]) {
                            low++;
                        }

                        // move backward if next number is same as previous number
                        while (low < high && nums[high - 1] == nums[high]) {
                            high--;
                        }

                        // move pointers
                        low++;
                        high--;

                    } else if (nums[low] + nums[high] < target) {
                        low++;
                    } else if (nums[low] + nums[high] > target) {
                        high--;
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Solution_Sort_Two_Pointer foo = new Solution_Sort_Two_Pointer();

        List<List<Integer>> results = foo.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println(Arrays.toString(results.toArray()));
    }
}
