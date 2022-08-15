package Algorithm.LeetCode.LeetCode_1423_Maximum_Points_You_Can_Obtain_from_Cards;

// Inspired by https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/solution/ke-huo-de-de-zui-da-dian-shu-by-leetcode-7je9/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int min = 0;
        
        for (int i = 0; i < cardPoints.length - k; i++) {
            min += cardPoints[i];
        }

        int total = min;

        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            total += cardPoints[i];
        }


        int low = 0, high = cardPoints.length - k;

        int sum = min;

        while (high < cardPoints.length) {
            sum = sum - cardPoints[low++] + cardPoints[high++];

            min = Math.min(min, sum);
        }

        return total - min;
    }
}