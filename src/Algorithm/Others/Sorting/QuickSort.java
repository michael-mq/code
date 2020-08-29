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
        swap(nums, randIndex, hi);

        int i, j;

        for (i = lo, j = lo; j < hi; j++) {
            if (nums[j] <= nums[hi]) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, j);

        return i;
    }

    int randRange(int lo, int hi) {
        Random random_num = new Random();
        return lo + random_num.nextInt(hi - lo);
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
