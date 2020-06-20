package Algorithm.LeetCode.LeetCode_84_LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Monotone_Stack_Sentinel {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int area = 0;

        int[] newHights = new int[len + 2];

        for (int i = 0; i < len; i++) {
            newHights[i + 1] = heights[i];
        }

        len += 2;
        heights = newHights;

        // Deque is double ended and performance better
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        // Check if current height is lower than last height
        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];

                // Does NOT make difference
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }

                int width;
                width = i - stack.peekLast() - 1;

                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }

        return area;
    }

    public static void main(String[] args) {
        Solution_Monotone_Stack_Sentinel foo = new Solution_Monotone_Stack_Sentinel();

        System.out.println(foo.largestRectangleArea(new int[]{
                2, 1, 5, 6, 2, 3
        }));
    }
}
