package Algorithm.Others.Sorting;

import java.util.Arrays;

class InsertionSort {
    int[] sort(int[] nums) {

        int current, j;

        for (int i = 1; i < nums.length; i++) {
            current = nums[i];

//            System.out.println("i: " + i);
//            System.out.println("current: " + current);

            for (j = i - 1; j >= 0; j--) {
//                System.out.println("  j: " + j);
                if (nums[j] > current) {
                    nums[j + 1] = nums[j];
//                    System.out.println("  " + Arrays.toString(nums));
//                    System.out.println();
                } else {
//                    System.out.println();
                    break;
                }
            }

//            System.out.println("j: " + j);
//            System.out.println("nums[" + (j + 1) + "] = " + current);
            nums[j + 1] = current;

//            System.out.println(Arrays.toString(nums));
//            System.out.println();
//            System.out.println();
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

