from typing import List


# https://www.programmercarl.com/0718.最长重复子数组.html
class Solution_DP:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        result = 0
        length1 = len(nums1)
        length2 = len(nums2)

        dp = [[0] * (length2 + 1) for _ in range(0, length1 + 1)]

        for i in range(1, length1 + 1):
            for j in range(1, length2 + 1):
                if nums1[i - 1] == nums2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                result = max(result, dp[i][j])

        return result
