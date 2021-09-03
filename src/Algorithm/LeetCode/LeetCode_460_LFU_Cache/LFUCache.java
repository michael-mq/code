package Algorithm.LeetCode.LeetCode_460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    Map<Integer, Integer> keyToVal;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minFreq;
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
        cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);

        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);

            return;
        }

        if (cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);

        LinkedHashSet<Integer> set = freqToKeys.getOrDefault(1, new LinkedHashSet<>());
        set.add(key);
        freqToKeys.put(1, set);

        minFreq = 1;
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        LinkedHashSet<Integer> set = freqToKeys.get(freq);
        set.remove(key);

        LinkedHashSet<Integer> higherSet = freqToKeys.getOrDefault(freq + 1, new LinkedHashSet<>());
        higherSet.add(key);
        freqToKeys.put(freq + 1, higherSet);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);

            if (freq == minFreq) {
                minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> set = freqToKeys.get(minFreq);
        int deletedKey = set.iterator().next();
        set.remove(deletedKey);

        if (set.isEmpty()) {
            freqToKeys.remove(minFreq);
//            minFreq++; no need because it will be set to 1 during input
        }

        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
