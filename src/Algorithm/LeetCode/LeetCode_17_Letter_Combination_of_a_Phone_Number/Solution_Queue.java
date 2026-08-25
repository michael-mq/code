package Algorithm.LeetCode.LeetCode_17_Letter_Combination_of_a_Phone_Number;

import java.util.*;

class Solution_Queue {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

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

        Queue<String> q = new LinkedList<>();

        q.offer("");

        for (char c : digits.toCharArray()) {
            List<String> list = map.get(c);
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String temp = q.poll();

                for (String s : list) {
                    q.offer(temp + s);
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }
}

