package Algorithm.LeetCode.CN.Interview_16_02;

import java.util.HashMap;
import java.util.Map;

class WordsFrequency {
    private String[] book;
    private Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        this.book = book;
        this.map = new HashMap<>();

        for (String word : book) {
            this.map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return map.containsKey(word) ? map.get(word) : 0;
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */