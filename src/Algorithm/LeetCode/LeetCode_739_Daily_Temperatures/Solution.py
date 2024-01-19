# https://www.programmercarl.com/0739.每日温度.html
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        length = len(temperatures)
        result = [0] * length
        stack = [0]

        for i in range(1, length):
            while len(stack) > 0 and temperatures[i] > temperatures[stack[-1]]:
                result[stack[-1]] = i - stack[-1]
                stack.pop()

            stack.append(i)

        return result
