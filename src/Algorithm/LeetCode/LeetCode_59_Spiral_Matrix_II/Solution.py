from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        matrix = [[0] * n for _ in range(n)]
        left, right = 0, n - 1
        top, bottom = 0, n - 1
        count = 0

        while True:
            for column in range(left, right + 1):
                count += 1
                matrix[top][column] = count

            top += 1
            if top > bottom:
                break

            for row in range(top, bottom + 1):
                count += 1
                matrix[row][right] = count

            right -= 1
            if right < left:
                break

            for column in range(right, left - 1, -1):
                count += 1
                matrix[bottom][column] = count

            bottom -= 1
            if bottom < top:
                break

            for row in range(bottom, top - 1, -1):
                count += 1
                matrix[row][left] = count

            left += 1
            if left > right:
                break

        return matrix
