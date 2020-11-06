package Algorithm.Others.Sorting;

import java.util.Arrays;
import java.util.Random;

class QuickSort {
    int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;

        int p = partition(nums, lo, hi);

        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    int partition(int[] nums, int lo, int hi) {
        int randIndex = randRange(lo, hi);

        // Move randomly picked pivot to the end
        // So nums[hi] becomes the previous nums[randIndex]
        swap(nums, randIndex, hi);

        // Real partition starts
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

    int randRange(int lo, int hi) {
        return lo + new Random().nextInt(hi - lo);
    }

    void swap(int[] nums, int i, int j) {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] nums = {2, 1, 7, 9, 5, 8};

        System.out.println(Arrays.toString(quickSort.sort(nums)));
    }
}
