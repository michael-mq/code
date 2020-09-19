package Algorithm.LeetCode.LeetCode_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution_Linear_MyOwn {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int len = nums.length;

        if (len == 0 || target < nums[0]) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                res[0] = i;
                break;
            }
        }

        if (res[0] == -1) {
            return res;
        }

        for (int i = res[0]; i < len; i++) {
            if (nums[i] == target) {
                res[1] = i;
            }
        }

        return res;
    }
}
