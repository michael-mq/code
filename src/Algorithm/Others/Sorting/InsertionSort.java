package Algorithm.Others.Sorting;

import java.util.Arrays;

class InsertionSort {
    int[] sort(int[] nums) {

        int current, j;

        for (int i = 1; i < nums.length; i++) {
            current = nums[i];

            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > current) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }

            nums[j + 1] = current;
        }

        return nums;
    }
}

class InsertionSortMain {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] nums = {2, 1, 7, 9, 5, 8};

        System.out.println(Arrays.toString(insertionSort.sort(nums)));
    }
}

