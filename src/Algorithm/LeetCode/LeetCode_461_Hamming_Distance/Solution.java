package Algorithm.LeetCode.LeetCode_461_Hamming_Distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int xy = x ^ y;

        while (xy > 0) {
            if ((xy & 1) == 1) {
                result++;
            }

            xy = xy >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.hammingDistance(1, 4));

    }
}
