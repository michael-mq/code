package Algorithm.HackerRank.HackRank_Recursion_Fibonacci_Numbers;

public class Solution_Recursion {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
