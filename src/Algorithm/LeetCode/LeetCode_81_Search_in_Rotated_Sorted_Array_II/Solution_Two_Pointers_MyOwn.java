package Algorithm.LeetCode.LeetCode_81_Search_in_Rotated_Sorted_Array_II;

class Solution_Two_Pointers_MyOwn {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (left == right) {
            return nums[left] == target;
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (target == nums[mid]) {
                return true;
            }

            if (nums[mid] >= nums[left]) { // left side might be ordered
                if (nums[mid] == nums[left]) { // important
                    left++;
                } else if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if (nums[mid] <= nums[right]) { // right side might be ordered
                if (nums[mid] == nums[right]) { // important
                    right--;
                } else if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Two_Pointers_MyOwn foo = new Solution_Two_Pointers_MyOwn();
        System.out.println(foo.search(new int[]{2,5,6,0,0,1,2}, 2));
        System.out.println(foo.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(foo.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
    }
}
