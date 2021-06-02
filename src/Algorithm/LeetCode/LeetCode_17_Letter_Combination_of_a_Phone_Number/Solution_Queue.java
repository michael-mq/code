package Algorithm.LeetCode.LeetCode_17_Letter_Combination_of_a_Phone_Number;

import java.util.*;

class Solution_Queue {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
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

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for (int i = 0; i < digits.length(); i++) {
            List<String> list = map.get(digits.charAt(i));
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String temp = queue.poll();

                for (int k = 0; k < list.size(); k++) {
                    queue.add(temp + list.get(k));
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}

