package Algorithm.LeetCode.LeetCode_189_Rotate_Array;

class Solution_ExtraSpace {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[(i + k) % len] = nums[i];
        }

        System.arraycopy(result, 0, nums, 0, len);
    }
}
