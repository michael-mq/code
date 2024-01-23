from typing import List

# https://www.programmercarl.com/0209.长度最小的子数组.html
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        i, sum, result = 0, nums[0], float('inf')

        for j in range(len(nums)):
            sum += nums[j]

            while sum >= target:
                result = min(result, j - i + 1)
                sum -= nums[i]
                i += 1

        return result if result != float('inf') else 0
