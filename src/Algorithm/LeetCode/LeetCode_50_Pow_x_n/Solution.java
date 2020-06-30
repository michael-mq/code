package Algorithm.LeetCode.LeetCode_50_Pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1 / pow(x, n);
        }
    }

    public double pow(double x, int n) {
        if (n == 0) return 1;

        double y = pow(x, n / 2);

        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        System.out.println(foo.myPow(2, 6));
    }
}
