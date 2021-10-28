package Algorithm.LeetCode.LeetCode_384_Shuffle_an_Array;

import java.util.Random;

class Solution {
    private int[] nums;
    private int[] original;
    private Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
    }

    public int[] reset() {
        nums = original.clone();
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            swap(i, randRange(i, nums.length));
        }

        return nums;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
