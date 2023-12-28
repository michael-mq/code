import sys
from typing import List

# https://www.programmercarl.com/0121.买卖股票的最佳时机.html
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        low = sys.maxsize
        result = 0

        for p in prices:
            low = min(low, p)
            result = max(result, p - low)

        return result
