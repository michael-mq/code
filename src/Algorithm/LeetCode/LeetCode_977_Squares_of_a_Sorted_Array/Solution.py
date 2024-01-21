from typing import List


# https://www.programmercarl.com/0977.有序数组的平方.html
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)
        k = len(nums) - 1

        left = 0
        right = len(nums) - 1

        while left <= right:
            if nums[left] * nums[left] < nums[right] * nums[right]:
                result[k] = nums[right] * nums[right]
                right -= 1
            else:
                result[k] = nums[left] * nums[left]
                left += 1

            k -= 1

        return result
