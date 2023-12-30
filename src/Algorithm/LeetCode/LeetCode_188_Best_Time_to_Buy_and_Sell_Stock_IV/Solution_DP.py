from typing import List


# https://www.programmercarl.com/0188.买卖股票的最佳时机IV.html
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        length = len(prices)
        dp = [[0] * (2 * k + 1) for _ in range(length)]

        for j in range(1, 2 * k, 2):
            dp[0][j] = -prices[0]

        for i in range(1, length):
            for j in range(0, 2 * k - 1, 2):
                dp[i][j + 1] = max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i])
                dp[i][j + 2] = max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i])

        return dp[-1][-1]
