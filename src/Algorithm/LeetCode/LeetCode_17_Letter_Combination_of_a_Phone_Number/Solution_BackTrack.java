package Algorithm.LeetCode.LeetCode_17_Letter_Combination_of_a_Phone_Number;

import java.util.*;

public class Solution_BackTrack {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>() {{
            put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
            put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
            put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
            put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
            put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
            put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
            put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
            put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        }};

        backTrack(map, digits, combinations, new StringBuffer(), 0);

        return combinations;
    }

    private void backTrack(Map<Character, ArrayList<String>> map, String digits, List<String> combinations, StringBuffer combination, int index) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            ArrayList<String> list = map.get(digits.charAt(index));

            for (int i = 0; i < list.size(); i++) {
                combination.append(list.get(i));

                backTrack(map, digits, combinations, combination, index + 1);

                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
