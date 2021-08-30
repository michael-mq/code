package Algorithm.LeetCode.LeetCode_33_Search_In_Rotated_Sorted_Array;

public class SearchInRotatedSortedArrayBS_33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        return binarySearch(nums, lo, hi, target);
    }

    int binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[lo] <= nums[mid]) { // check if left part is sorted
            if (nums[lo] <= target && target < nums[mid]) { // if target is at left part
                return binarySearch(nums, lo, mid - 1, target); // main find
            } else { // if target is at right prat
                return binarySearch(nums, mid + 1, hi, target);
            }
        } else { // if right part is sorted
            if (nums[mid] < target && target <= nums[hi]) { // if target is at right part
                return binarySearch(nums, mid + 1, hi, target); // main find
            } else { // if target is at left part
                return binarySearch(nums, lo, mid - 1, target);
            }
        }
    }
}

class SearchInRotatedSortedArrayBS_33_Main {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayBS_33 foo = new SearchInRotatedSortedArrayBS_33();

        System.out.println(foo.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
