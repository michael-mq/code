# https://www.programmercarl.com/0072.编辑距离.html
class Solution_DP:
    def minDistance(self, word1: str, word2: str) -> int:
        length1 = len(word1)
        length2 = len(word2)

        dp = [[0] * (length2 + 1) for _ in range(length1 + 1)]

        for i in range(length1 + 1):
            dp[i][0] = i

        for j in range(length2 + 1):
            dp[0][j] = j

        for i in range(1, length1 + 1):
            for j in range(1, length2 + 1):
                if (word1[i - 1] == word2[j - 1]):
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1

        return dp[-1][-1]
