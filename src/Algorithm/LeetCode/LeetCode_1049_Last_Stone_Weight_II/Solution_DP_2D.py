# https://www.programmercarl.com/1049.最后一块石头的重量II.html
class Solution(object):
    def lastStoneWeightII(self, stones):
        m = len(stones)
        total = sum(stones)
        target = total / 2
        dp = [[0] * (target + 1) for _ in range(m)]

        for j in range(stones[0], target + 1):
            dp[0][j] = stones[0]

        for i in range(1, m):
            for j in range(1, target + 1):
                if (j < stones[i]):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i])

        return total - 2 * dp[m - 1][target]
