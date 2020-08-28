package Algorithm.LeetCode.LeetCode_191_Number_Of_1_Bits;

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            n = n & (n - 1);
            res++;
        }

        return res;
    }


    public static void main(String[] args) {
        Solution foo = new Solution();
        System.out.println(foo.hammingWeight(20));
    }
}
