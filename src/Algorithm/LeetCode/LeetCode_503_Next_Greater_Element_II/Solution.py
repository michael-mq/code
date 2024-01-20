from typing import List


# https://www.programmercarl.com/0503.下一个更大元素II.html
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        stack = [0]

        for i in range(1, n * 2):
            while len(stack) != 0 and nums[stack[-1]] < nums[i % n]:
                result[stack[-1]] = nums[i % n]
                stack.pop()
            stack.append(i)

        return result
