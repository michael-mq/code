from typing import List


# https://www.programmercarl.com/0300.最长上升子序列.html
class Solution_DP:
    def lengthOfLIS(self, nums: List[int]) -> int:
        length = len(nums)
        dp = [1] * length

        for i in range(1, length):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return dp[-1]
