package Algorithm.LeetCode.LeetCode_380_Insert_Delete_GetRandom_O_1;

import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> dict;
    private List<Integer> list;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;

        dict.put(val, list.size());
        list.add(list.size(), val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) return false;

        int index = dict.get(val);
        int lastVal = list.get(list.size() - 1);

        list.set(index, lastVal);
        dict.put(lastVal, index);

        list.remove(list.size() - 1);
        dict.remove(val);

        return true;

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
