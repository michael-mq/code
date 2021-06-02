package Algorithm.LeetCode.LeetCode_17_Letter_Combination_of_a_Phone_Number;

import java.util.*;

class Solution_My_Own {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, ArrayList<String>> map = new HashMap<>();

        map.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        List<String> result = map.get(digits.charAt(0));

        return helper(map, result, digits, 1);
    }

    private List<String> helper(Map<Character, ArrayList<String>> map, List<String> result, String digits, int i ) {
        if (i == digits.length()) {
            return result;
        }

        List<String> temp = map.get(digits.charAt(i));
        List<String> newList = new ArrayList<>();

        for (int j = 0; j < result.size(); j++) {
            for (int k = 0; k < temp.size(); k++) {
                newList.add(result.get(j) + temp.get(k));
            }
        }

        return helper(map, newList, digits, i + 1);
    }
}

