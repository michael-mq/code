package Algorithm.LeetCode.LeetCode_223_Rectangle_Area;

public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        if (ax2 <= bx1 || bx2 <= ax1 || ay2 <= by1 || by2 <= ay1) {
            return areaA + areaB;
        }

        int X1 = Math.max(ax1, bx1);
        int Y1 = Math.max(ay1, by1);
        int X2 = Math.min(ax2, bx2);
        int Y2 = Math.min(ay2, by2);

        int areaOverLapping = (X2 - X1) * (Y2 - Y1);

        return areaA + areaB - areaOverLapping;
    }
}
