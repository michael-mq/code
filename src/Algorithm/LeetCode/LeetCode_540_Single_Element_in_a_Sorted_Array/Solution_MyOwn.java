package Algorithm.LeetCode.LeetCode_540_Single_Element_in_a_Sorted_Array;

public class Solution_MyOwn {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == nums[mid - 1]) {
                if ((mid - 1 - left) % 2 != 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((mid - 1 - left) % 2 != 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution_MyOwn solution_myOwn = new Solution_MyOwn();

        System.out.println(solution_myOwn.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
