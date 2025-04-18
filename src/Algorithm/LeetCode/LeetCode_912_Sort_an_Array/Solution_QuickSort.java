package Algorithm.LeetCode.LeetCode_912_Sort_an_Array;

//https://suanfa8.com/quick-sort/quick-sort-basic
class Solution_QuickSort {
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
        int pivot = nums[left];

        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
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