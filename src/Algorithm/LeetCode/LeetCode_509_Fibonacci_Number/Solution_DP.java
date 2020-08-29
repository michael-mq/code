package Algorithm.LeetCode.LeetCode_509_Fibonacci_Number;

public class Solution_DP {
    public int fib(int N) {
        if (N < 2) return N;

        int[] f = new int[N + 1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i < N + 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[N];
    }

    public static void main(String[] args) {
        Solution_DP foo = new Solution_DP();

        System.out.println(foo.fib(2));
        System.out.println(foo.fib(3));
        System.out.println(foo.fib(4));
    }
}
