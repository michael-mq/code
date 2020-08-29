package Algorithm.Others.Sorting;

import java.util.Arrays;

class MergeSort {
    int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);

        return nums;
    }

    void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;

        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);
    }

    void merge(int[] nums, int lo, int mid, int hi) {
        int[] copy = nums.clone();

        int k = lo, i = lo, j = mid + 1;

        while (k <= hi) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j > hi) {
                nums[k++] = copy[i++];
            } else if (copy[i] < copy[j]) {
                nums[k++] = copy[i++];
            } else {
                nums[k++] = copy[j++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] nums = {2, 1, 7, 9, 5, 8};

        System.out.println(Arrays.toString(mergeSort.sort(nums)));
    }
}
