package Algorithm.LeetCode.LeetCode_1762_Buildings_With_an_Ocean_View;

import java.util.ArrayList;
import java.util.List;

class Solution_MyOwn {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int max = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                list.add(i);
            }

            max = Math.max(max, heights[i]);
        }

        int length = list.size();
        int[] result = new int[length];

        for (int i = 0, j = length - 1; i < length && j >= 0; i++, j--) {
            result[i] = list.get(j);
        }

        return result;
    }
}