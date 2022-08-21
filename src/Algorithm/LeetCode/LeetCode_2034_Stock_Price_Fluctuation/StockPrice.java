package Algorithm.LeetCode.LeetCode_2034_Stock_Price_Fluctuation;

import java.util.*;

class StockPrice {
    Map<Integer, Integer> timestamps;
    int latest;
    TreeMap<Integer, Integer> prices;

    public StockPrice() {
        timestamps = new HashMap<>();
        latest = 0;
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timestamps.containsKey(timestamp)) {
            int oldPrice = timestamps.get(timestamp);
            int count = prices.get(oldPrice);
            
            if (count == 1) {
                prices.remove(oldPrice);
            } else {
                prices.put(oldPrice, count - 1);
            }
        }

        timestamps.put(timestamp, price);
        prices.put(price, prices.getOrDefault(price, 0) + 1);
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