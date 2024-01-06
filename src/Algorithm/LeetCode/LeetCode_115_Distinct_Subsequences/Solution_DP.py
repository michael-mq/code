# https://programmercarl.com/0115.不同的子序列.html
class Solution_DP:
    def numDistinct(self, s: str, t: str) -> int:
        length1 = len(s)
        length2 = len(t)

        dp = [[0] * (length2 + 1) for _ in range(length1 + 1)]

        for i in range(length1 + 1):
            dp[i][0] = 1

        for j in range(1, length2 + 1):
            dp[0][j] = 0

        for i in range(1, length1 + 1):
            for j in range(1, length2 + 1):
                if s[i - 1] == t[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j]

        return dp[-1][-1]
