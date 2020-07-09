package Algorithm.LeetCode.LeetCode_69_Sqrt_x;

public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 0;
        // right must be less than x / 2;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // long >= int * int
            long temp = (long) mid * mid;

            if (temp == x) {
                return mid;
            }

            if (temp < x) {
                left = mid + 1;
            } else if (temp > x) {
                right = mid - 1;
            }
        }

        // because after the loop, left > right
        // and we are truncating the the decimal part
        // so we take the smaller one
        return right;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        System.out.println(foo.mySqrt(4));
        System.out.println(foo.mySqrt(6));
        System.out.println(foo.mySqrt(8));
        System.out.println(foo.mySqrt(144));
    }
}