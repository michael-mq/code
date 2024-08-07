package Algorithm.LeetCode.LeetCode_72_Edit_Distance;

/**
 *    | '' | r | o | s
 * ------------------------------
 * '' |  0 | 1 | 2 | 3
 *  h |  1 | 1 | 2 | 3
 *  o |  2 | 2 | 1 | 2
 *  r |  3 | 2 | 2 | 2
 *  s |  4 | 3 | 3 | 2
 *  e |  5 | 4 | 4 | 3
 */

//https://leetcode.cn/problems/edit-distance/solutions/188223/bian-ji-ju-chi-by-leetcode-solution
public class Solution_DP {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        // 有一个字符串为空串
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 边界状态初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 否则在以下三种情况中选出步骤最少的，这是「动态规划」的「最优子结构」
                // 1、在下标 i 处插入一个字符
                int insert = dp[i][j - 1] + 1;
                // 2、替换一个字符
                int replace = dp[i - 1][j - 1] + 1;
                // 3、删除一个字符
                int delete = dp[i - 1][j] + 1;

                dp[i][j] = Math.min(replace, Math.min(insert, delete));
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution_DP foo = new Solution_DP();

        System.out.println(foo.minDistance("horse", "ros"));
        System.out.println(foo.minDistance("intention", "execution"));
    }
}
