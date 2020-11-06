package Algorithm.LeetCode.LeetCode_215_Kth_Largest_Element_in_an_Array;

import java.util.Random;

public class Solution_Two_Pointer_Random {
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
        if (lo < hi) {
            randomise(nums, lo, hi);
        }

        int pivot = nums[hi];

        int lt = lo;
        int rt = hi - 1;

        while (true) {
            while (lt <= rt && nums[lt] < pivot) {
                lt++;
            }

            while (lt <= rt && nums[rt] > pivot) {
                rt--;
            }

            if (lt > rt) {
                break;
            }

            swap(nums, lt, rt);
            lt++;
            rt--;
        }

        swap(nums, lt, hi);

        return lt;
    }

    void swap(int[] nums, int i, int j) {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void randomise(int[] nums, int lo, int hi) {
        Random random = new Random();
        int randomIndex = lo + 1 + random.nextInt(hi - lo);
        swap(nums, randomIndex, hi);
    }
}
