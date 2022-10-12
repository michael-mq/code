package Algorithm.LeetCode.LeetCode_875_Koko_Eating_Bananas;

// https://leetcode.cn/problems/koko-eating-bananas/solution/er-fen-cha-zhao-ding-wei-su-du-by-liweiwei1419/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (calculateSum(piles, mid) == h) { // if the speed is ok, we should try to see if there is a slower speed
                high = mid;
            } else if (calculateSum(piles, mid) > h) { // too slow, needs to increase speed
                low = mid + 1;
            } else { // too fast, try to be slower
                high = mid;
            }
        }

        return low;
    }

    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile % speed == 0 ? pile / speed : pile / speed + 1;
        }
        return sum;
    }
}