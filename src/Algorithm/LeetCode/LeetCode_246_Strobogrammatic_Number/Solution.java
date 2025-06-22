package Algorithm.LeetCode.LeetCode_246_Strobogrammatic_Number;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int n = num.length();

        int i = 0, j = n - 1;

        while (i <= j) {
            char left = num.charAt(i);
            char right = num.charAt(j);

            if (!map.containsKey(left) || map.get(left) != right) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}