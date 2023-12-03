# https://www.programmercarl.com/1049.最后一块石头的重量II.html
class Solution(object):
    def lastStoneWeightII(self, stones):
        total = sum(stones)
        target = total / 2
        dp = [0] * (target + 1)

        for stone in stones:
            for j in range(target, stone - 1, -1):
                dp[j] = max(dp[j], dp[j - stone] + stone)

        return total - 2 * dp[target]
