package Algorithm.LeetCode.LeetCode_246_Strobogrammatic_Number;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution_MyOwn {
    public boolean isStrobogrammatic(String num) {
        Set<Character> set = Set.of('0', '1', '8');

        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int n = num.length();

        if (n == 1 && !set.contains(num.charAt(0))) {
            return false;
        }

        if (n == 1 && set.contains(num.charAt(0))) {
            return true;
        }

        if (n % 2 != 0 && !set.contains(num.charAt(n / 2))) {
            return false;
        }

        int i = 0, j = n - 1;

        while (i < j) {
            char left = num.charAt(i);
            char right = num.charAt(j);

            if (!map.containsKey(left)) {
                return false;
            }

            if (map.get(left) != right) {
                return false;
            }

            i++;
            j--;
        }

        if (i == j && set.contains(num.charAt(i))) {
            return true;
        }

        return true;
    }
}