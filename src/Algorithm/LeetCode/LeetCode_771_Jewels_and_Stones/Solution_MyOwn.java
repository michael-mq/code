package Algorithm.LeetCode.LeetCode_771_Jewels_and_Stones;

import java.util.HashMap;
import java.util.Map;

class Solution_MyOwn {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> cntStones = new HashMap<>();

        for (char c : stones.toCharArray()) {
            cntStones.put(c, cntStones.getOrDefault(c, 0) + 1);
        }

        int answer = 0;

        for (char c : jewels.toCharArray()) {
            answer += cntStones.getOrDefault(c, 0);
        }

        return answer;
    }
}