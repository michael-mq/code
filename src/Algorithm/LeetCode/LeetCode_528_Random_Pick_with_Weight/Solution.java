package Algorithm.LeetCode.LeetCode_528_Random_Pick_with_Weight;

import java.util.Random;

//https://www.youtube.com/watch?v=fWS0TCcr-lE
class Solution {
    private int sum = 0;
    private final int[] arr;
    private final Random random = new Random();

    public Solution(int[] w) {
        arr = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            arr[i] = sum;
        }
    }

    public int pickIndex() {
        int n = random.nextInt(sum) + 1;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (n < arr[mid]) {
                hi = mid;
            } else if (n > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{2, 1, 3});
        System.out.println(obj.pickIndex());
    }
}
