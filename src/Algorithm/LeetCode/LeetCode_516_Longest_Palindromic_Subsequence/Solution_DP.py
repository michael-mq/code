# https://www.programmercarl.com/0516.最长回文子序列.html
class Solution_DP:
    def longestPalindromeSubseq(self, s: str) -> int:
        length = len(s)

        dp = [[0] * length for _ in range(length)]

        for i in range(length, -1, -1):
            dp[i][i] = 1
            for j in range(i + 1, length):
                if (s[i] == s[j]):
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])

        return dp[-1][-1]
