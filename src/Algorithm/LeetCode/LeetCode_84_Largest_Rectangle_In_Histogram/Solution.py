from typing import List


# https://www.programmercarl.com/0084.柱状图中最大的矩形.html
# Check video
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.insert(0, 0)
        heights.append(0)
        result = 0
        stack = [0]

        for i in range(1, len(heights)):
            while stack and heights[i] < heights[stack[-1]]:
                mid_index = stack[-1]
                stack.pop()
                if stack:
                    left_index = stack[-1]
                    right_index = i
                    width = right_index - left_index - 1
                    height = heights[mid_index]

                    result = max(result, width * height)
            stack.append(i)

        return result
