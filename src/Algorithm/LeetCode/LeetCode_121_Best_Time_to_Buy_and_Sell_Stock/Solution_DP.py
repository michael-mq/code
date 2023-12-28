from typing import List


class Solution_DP:
    def maxProfit(self, prices: List[int]) -> int:
        length = len(prices)
        dp = [[0] * 2 for _ in range(length)]
        dp[0][0] = -prices[0]

        for i in range(1, length):
            dp[i][0] = max(dp[i - 1][0], -prices[i])
            dp[i][1] = max(dp[i - 1][0] + prices[i], dp[i - 1][1])

        return dp[-1][1]
