from typing import List


# https://www.programmercarl.com/0496.下一个更大元素I.html
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = [-1] * len(nums1)
        stack = [0]

        for i in range(1, len(nums2)):
            while len(stack) != 0 and nums2[stack[-1]] < nums2[i]:
                if nums2[stack[-1]] in nums1:
                    index = nums1.index(nums2[stack[-1]])
                    result[index] = nums2[i]
                stack.pop()
            stack.append(i)

        return result
