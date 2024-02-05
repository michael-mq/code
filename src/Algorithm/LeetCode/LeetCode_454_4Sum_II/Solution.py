from typing import List


class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        result = 0
        map = {}

        for n1 in nums1:
            for n2 in nums2:
                sum = n1 + n2
                if sum in map:
                    map[sum] += 1
                else:
                    map[sum] = 1

        for n3 in nums3:
            for n4 in nums4:
                sum = -(n3 + n4)

                if sum in map:
                    result += map[sum]

        return result
