from typing import List


# https://www.programmercarl.com/0053.最大子序和（动态规划）.html
class Solution_DP:
    def maxSubArray(self, nums: List[int]) -> int:
        result = 0
        length = len(nums)
        dp = [0] * length

        dp[0] = nums[0]
        result = dp[0]

        for i in range(1, length):
            dp[i] = max(dp[i - 1] + nums[i], nums[i])
            result = max(result, dp[i])

        return result
