from typing import List


def reverse(s: List[str], left: int, right: int):
    while left < right:
        tmp = s[left]
        s[left] = s[right]
        s[right] = tmp

        left += 1
        right -= 1

    return s


class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        i = 0
        res = list(s)

        while i < len(s):
            left = i
            right = min(i + k - 1, len(s) - 1)

            reverse(res, left, right)

            i += 2 * k

        return ''.join(res)
