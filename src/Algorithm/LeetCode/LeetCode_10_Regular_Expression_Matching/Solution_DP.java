package Algorithm.LeetCode.LeetCode_10_Regular_Expression_Matching;

class Solution_DP {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] 表示 s 的前 i 个字符与 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // --- 1. 初始化 ---
        dp[0][0] = true; // 两个空串互相匹配

        // --- 2. 预处理第一行：当字符串 s 为空时，哪些模式 p 能匹配 ---
        // 只有像 "a*b*c*" 这种由 '*' 组成的模式才能匹配空串
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                // 如果当前是 '*'，它能不能消掉前面的字符匹配空串，取决于往前退两格的结果
                dp[0][j] = dp[0][j - 2];
            }
        }

        // --- 3. 开始填表 ---
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);

                // 情况 A：当前字符匹配（相同或是 '.'）
                if (currentP == currentS || currentP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 情况 B：遇到 '*'
                else if (currentP == '*') {
                    char prevP = p.charAt(j - 2); // 获取 '*' 前面的那个字符

                    // 子情况 1：'*' 前面的字符与当前 s 字符不匹配
                    if (prevP != currentS && prevP != '.') {
                        // 此时只能让 '*' 匹配 0 次，强行消掉前面的字符
                        dp[i][j] = dp[i][j - 2];
                    }
                    // 子情况 2：'*' 前面的字符能匹配当前 s 字符
                    else {
                        /*
                         * 这时有三种逻辑可能性，满足其一即为 true：
                         * 1. dp[i][j - 2]   : 匹配 0 次。把 'x*' 整个扔掉。
                         * 2. dp[i - 1][j - 2] : 匹配 1 次。把 'x*' 当做一个普通字符。
                         * 3. dp[i - 1][j]     : 匹配多次。利用这个 '*' 继续匹配 s 的前一个字符。
                         */
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];

                        /* * 【进阶笔记】：
                         * 其实上述代码中的 dp[i - 1][j - 2]（匹配 1 次）是可以省略的。
                         * 因为 dp[i - 1][j]（匹配多次）在计算过程中已经包含了 dp[i - 1][j - 2] 的状态。
                         * 简写版：dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                         * 但保留三项式写法会让逻辑更直观，在面试中也更容易讲解清楚。
                         */
                    }
                }
                // 其余情况均为不匹配，dp[i][j] 默认为 false
            }
        }

        return dp[m][n];
    }
}