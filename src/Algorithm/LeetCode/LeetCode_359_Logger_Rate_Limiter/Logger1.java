package Algorithm.LeetCode.LeetCode_359_Logger_Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

class Logger1 {
    private Map<String, Integer> map;

    public Logger1() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = map.computeIfAbsent(message, s -> -10);

        if (timestamp - time >= 10) {
            map.put(message, timestamp);

            return true;
        }

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */