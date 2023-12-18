# https://www.programmercarl.com/0213.打家劫舍II.html
from typing import List


class Solution_DP:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)
        if length == 1:
            return nums[0]

        res1 = self.robRange(nums, 0, length - 2)
        res2 = self.robRange(nums, 1, length - 1)

        return max(res1, res2)

    def robRange(self, nums: List[int], start: int, end: int) -> int:
        if start == end:
            return nums[start]

        dp = [0] * len(nums)

        dp[start] = nums[start]
        dp[start + 1] = max(nums[start], nums[start + 1])

        for i in range(start + 2, end + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        return dp[end]
