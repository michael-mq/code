package Algorithm.LeetCode.LeetCode_912_Sort_an_Array;

import java.util.Random;

//https://suanfa8.com/quick-sort/random-select-pivot
class Solution_QuickSort_Random {
    private final static Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int pivot = nums[left];

        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= nums[left]) {
                j++;
                swap(nums, i, j);
            }
        }

        swap(nums, left, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}