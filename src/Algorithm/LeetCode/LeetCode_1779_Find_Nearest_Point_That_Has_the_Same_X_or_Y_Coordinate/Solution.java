package Algorithm.LeetCode.LeetCode_1779_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int[] res = new int[]{Integer.MAX_VALUE, -1};

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int distance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);

                if (res[0] > distance) {
                    res[0] = distance;
                    res[1] = i;
                } else if (res[0] == distance) {
                    res[1] = Math.min(res[1], i);
                }
            }
        }

        return res[1];
    }
}
