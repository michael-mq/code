package Algorithm.LeetCode.LeetCode_120_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution_DP1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution_DP1 foo = new Solution_DP1();

        List<List<Integer>> bar = new ArrayList<>();

        bar.add(new ArrayList());
        bar.add(new ArrayList());
        bar.add(new ArrayList());
        bar.add(new ArrayList());

        bar.get(0).add(2);
        bar.get(1).add(3);
        bar.get(1).add(4);
        bar.get(2).add(6);
        bar.get(2).add(5);
        bar.get(2).add(7);
        bar.get(3).add(4);
        bar.get(3).add(1);
        bar.get(3).add(8);
        bar.get(3).add(3);

        System.out.println(foo.minimumTotal(bar));

        List<List<Integer>> bar1 = new ArrayList<>();

        bar1.add(new ArrayList());
        bar1.add(new ArrayList());
        bar1.add(new ArrayList());

        bar1.get(0).add(-1);
        bar1.get(1).add(2);
        bar1.get(1).add(3);
        bar1.get(2).add(1);
        bar1.get(2).add(-1);
        bar1.get(2).add(-3);

        System.out.println(foo.minimumTotal(bar1));
    }

}
