from typing import List


# https://www.programmercarl.com/0349.两个数组的交集.html#算法公开课
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        table = {}

        for num in nums1:
            table[num] = table.get(num, 0) + 1

        res = set()

        for num in nums2:
            if num in table:
                res.add(num)
                del table[num]

        return list(res)
