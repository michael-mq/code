package Algorithm.LeetCode.LeetCode_231_Power_of_Two;

/**
 *  1 = 00000001
 *  2 = 00000010
 *  4 = 00000100
 *  8 = 00001000
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n -1) == 0;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();
        System.out.println(foo.isPowerOfTwo(4));
        System.out.println(foo.isPowerOfTwo(30));
    }
}
