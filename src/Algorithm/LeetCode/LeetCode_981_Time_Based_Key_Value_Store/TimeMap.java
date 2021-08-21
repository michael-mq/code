package Algorithm.LeetCode.LeetCode_981_Time_Based_Key_Value_Store;

import java.util.HashMap;
import java.util.Map;

public class TimeMap {
    private Map<String, Map<Integer, String>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<Integer, String> _map = map.getOrDefault(key, new HashMap<>());
        _map.put(timestamp, value);
        map.put(key, _map);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Map<Integer, String> _map = map.get(key);

        for(int i = timestamp; i > 0; i--) {
            if (_map.containsKey(i)) {
                return _map.get(i);
            }
        }

        return "";
    }

//    public String get(String key, int timestamp) {
//        if (!map.containsKey(key)) {
//            return "";
//        }
//
//        Map<Integer, String> _map = map.get(key);
//
//        for(int i = timestamp; i > 0; i--) {
//            if (_map.containsKey(i)) {
//                return _map.get(i);
//            }
//        }
//
//        return "";
//    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
