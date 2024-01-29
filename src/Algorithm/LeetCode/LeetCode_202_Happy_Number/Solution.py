class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()

        while n not in seen:
            seen.add(n)
            n = self.getNext(n)

            if n == 1:
                return True

        return False

    def getNext(self, n: int) -> int:
        new_num = 0

        while n:
            n, r = divmod(n, 10)
            new_num += r ** 2

        return new_num
