package Algorithm.LeetCode.LeetCode_852_Peak_Index_in_a_Mountain_Array;

class Solution_BS_Jiuzhang_Template {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return arr[start] > arr[end] ? start : end;
    }
}