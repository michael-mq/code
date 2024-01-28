# https://www.programmercarl.com/0242.有效的字母异位词.htm
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        table = [0] * 26

        for c in s:
            table[ord(c) - ord('a')] += 1

        for c in t:
            table[ord(c) - ord("a")] -= 1
            if table[ord(c) - ord("a")] < 0:
                return False

        # for i in range(26):
        #     if table[i] != 0:
        #         return False

        return True
