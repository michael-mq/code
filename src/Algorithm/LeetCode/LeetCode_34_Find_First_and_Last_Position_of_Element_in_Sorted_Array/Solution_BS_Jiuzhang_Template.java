package Algorithm.LeetCode.LeetCode_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution_BS_Jiuzhang_Template {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        if (nums.length == 0) {
            return res;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[end] == target) {
            res[0] = end;
        }

        if (nums[start] == target) {
            res[0] = start;
        }

        start = 0;
        end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            res[1] = start;
        }

        if (nums[end] == target) {
            res[1] = end;
        }

        return res;
    }
}