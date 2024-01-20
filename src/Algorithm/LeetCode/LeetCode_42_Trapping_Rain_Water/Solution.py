from typing import List


# https://www.programmercarl.com/0042.接雨水.html
class Solution:
    def trap(self, height: List[int]) -> int:
        result = 0
        stack = [0]

        for i in range(1, len(height)):
            while stack and height[stack[-1]] < height[i]:
                mid_height_index = stack.pop()
                if stack:
                    h = min(height[stack[-1]], height[i]) - height[mid_height_index]
                    w = i - stack[-1] - 1
                    result += h * w

            stack.append(i)

        return result
