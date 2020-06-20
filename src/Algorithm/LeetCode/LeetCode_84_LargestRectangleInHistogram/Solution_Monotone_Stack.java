package Algorithm.LeetCode.LeetCode_84_LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Monotone_Stack {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int area = 0;

        // Deque is double ended and performance better
        Deque<Integer> stack = new ArrayDeque<>();

        // Check if current height is lower than last height
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];

                // Does NOT make difference
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }

        // Loop through the Monotonic stack
        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];

            // Does NOT make difference
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }

            int width;
            // the current item must be able to extend to the very end on right
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }
            area = Math.max(area, width * height);
        }

        return area;
    }

    public static void main(String[] args) {
        Solution_Monotone_Stack foo = new Solution_Monotone_Stack();

        System.out.println(foo.largestRectangleArea(new int[]{
                2, 1, 5, 6, 2, 3
        }));
    }
}
