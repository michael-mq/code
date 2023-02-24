package Algorithm.LeetCode.LeetCode_509_Fibonacci_Number;

public class Solution_Memo {
    public int fib(int N) {
        if (N < 2) return N;

        Integer[] memo = new Integer[31];

        memo[0] = 0;
        memo[1] = 1;

        return memorize(memo, N);
    }

    private int memorize(Integer[] memo, int N) {
        if (memo[N] != null) {
            return memo[N];
        }
        return memorize(memo, N - 1) + memorize(memo, N - 2);

    }

    public static void main(String[] args) {
        Solution_Memo foo = new Solution_Memo();

        System.out.println(foo.fib(2));
        System.out.println(foo.fib(3));
        System.out.println(foo.fib(4));
    }
}

//class Solution {
//    private int[] memo;
//
//    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        }
//
//        memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        memo[0] = 0;
//        memo[1] = 1;
//
//        return helper(n);
//    }
//
//    private int helper(int n) {
//        if (memo[n] == -1) {
//            return helper(n - 1) + helper(n - 2);
//        }
//
//        return memo[n];
//    }
//}
