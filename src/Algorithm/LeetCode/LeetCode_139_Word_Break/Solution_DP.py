from typing import List

# https://www.programmercarl.com/0139.单词拆分.html
class Solution:
    def wordBreak(self, s: str, wordDist: List[str]) -> bool:
        wordSet = set(wordDist)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break

        return dp[n]
