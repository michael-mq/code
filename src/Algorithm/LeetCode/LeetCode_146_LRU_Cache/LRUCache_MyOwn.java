package Algorithm.LeetCode.LeetCode_146_LRU_Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache_MyOwn {
    private Map<Integer, Integer> map;
    private LinkedList<Integer> list;
    private int capacity;

    public LRUCache_MyOwn(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.add(key);

            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (list.size() > capacity) {
            map.remove(list.getFirst());
            list.removeFirst();
            list.add(key);

        } else {
            list.remove(key);
            list.add(key);
        }

        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


//private TreeMap<Integer, Integer> map;
//    private int capacity;
//
//    public LRUCache_MyOwn(int capacity) {
//        map = new TreeMap<>();
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//        if (map.size() > capacity) {
//            map.pollLastEntry();
//        }
//
//        map.put(key, value);
//
//
//    }
