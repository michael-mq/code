# https://www.programmercarl.com/0647.回文子串.html
class Solution_DP:
    def countSubstrings(self, s: str) -> int:
        length = len(s)
        dp = [[False] * length for _ in range(length)]
        result = 0

        for i in range(length - 1, -1, -1):
            for j in range(i, length):
                if s[i] == s[j]:
                    if j - i <= 2:
                        dp[i][j] = True
                        result += 1
                    elif dp[i + 1][j - 1]:
                        dp[i][j] = True
                        result += 1

        return result
