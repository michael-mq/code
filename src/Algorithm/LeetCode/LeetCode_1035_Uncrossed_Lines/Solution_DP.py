from typing import List


# https://www.programmercarl.com/1035.不相交的线.html
class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        length1 = len(nums1)
        length2 = len(nums2)
        dp = [[0] * (length2 + 1) for _ in range(length1 + 1)]

        for i in range(1, length1 + 1):
            for j in range(1, length2 + 1):
                if (nums1[i - 1] == nums2[j - 1]):
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[-1][-1]
