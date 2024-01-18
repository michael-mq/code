# https://www.programmercarl.com/0647.回文子串.html
class Solution_TwoPointer:
    def countSubstrings(self, s: str) -> int:
        length = len(s)
        result = 0

        for i in range(length):
            result += self.extend(s, i, i, length)
            result += self.extend(s, i, i + 1, length)
        return result

    def extend(self, s: str, i: int, j: int, n: int):
        res = 0
        while (i >= 0 and j < n and s[i] == s[j]):
            res += 1
            i -= 1
            j += 1

        return res
