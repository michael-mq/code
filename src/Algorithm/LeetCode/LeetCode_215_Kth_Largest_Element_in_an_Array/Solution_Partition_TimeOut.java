package Algorithm.LeetCode.LeetCode_215_Kth_Largest_Element_in_an_Array;

public class Solution_Partition_TimeOut {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;

        int target = len - k;

        while (true) {
            int index = partition(nums, lo, hi);

            if (index == target) {
                return nums[index];
            } else if (index < target) {
                lo = index + 1;
            } else {
                hi = index - 1;
            }
        }
    }

    int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        int j;

        for (j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        // now `j == hi` which is the index of the pivot
        // then move the pivot to index `i` which is the 1st element larger than pivot
        // so `nums[i] == pivot` while `nums[0 .. i - 1 ] <= pivot`, `nums[i .. hi - 1] > pivot`, `nums[hi] = pivot`
        swap(nums, i, j);
        // now `nums[i] == pivot` while `nums[0 .. i - 1] <= pivot`, `nums[i] = pivot`, numbs[i + 1 .. hi] > pivot
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
