package Algorithm.LeetCode.LeetCode_2034_Stock_Price_Fluctuation;

import java.util.*;

class StockPrice_MyOwn {
    Map<Integer, Integer> timestamps;
    int latest;
    TreeMap<Integer, Set<Integer>> prices;

    public StockPrice_MyOwn() {
        timestamps = new HashMap<>();
        latest = 0;
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timestamps.containsKey(timestamp)) {
            int oldPrice = timestamps.get(timestamp);
            Set<Integer> set = prices.get(oldPrice);
            set.remove(timestamp);

            if (set.size() == 0) {
                prices.remove(oldPrice);
            }
        }

        timestamps.put(timestamp, price);

        if (prices.containsKey(price)) {
            Set<Integer> set = prices.get(price);
            set.add(timestamp);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(timestamp);
            prices.putIfAbsent(price, set);
        }

        latest = Math.max(latest, timestamp);
    }

    public int current() {
        return timestamps.get(latest);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}