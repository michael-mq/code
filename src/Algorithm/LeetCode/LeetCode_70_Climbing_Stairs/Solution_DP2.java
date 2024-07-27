package Algorithm.LeetCode.LeetCode_70_Climbing_Stairs;

public class Solution_DP2 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int pre = 1;
        int cur = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution_DP2 foo = new Solution_DP2();

        System.out.println(foo.climbStairs(2));
        System.out.println(foo.climbStairs(3));
    }
}
