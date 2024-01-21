from typing import List


# https://www.programmercarl.com/0027.移除元素.html
class Solution_2:
    def removeElement(self, nums: List[int], val: int) -> int:
        # The order of the elements may be changed.
        left = 0
        right = len(nums) - 1

        while left <= right:
            if nums[left] == val:
                nums[left] = nums[right]
                right -= 1
            else:
                left += 1

        return left
