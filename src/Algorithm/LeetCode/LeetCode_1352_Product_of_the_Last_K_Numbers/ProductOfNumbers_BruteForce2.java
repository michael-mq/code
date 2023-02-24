package Algorithm.LeetCode.LeetCode_1352_Product_of_the_Last_K_Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProductOfNumbers_BruteForce2 {
    private List<Integer> list;
    private Map<int[], Integer> map;

    public ProductOfNumbers_BruteForce2() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int[] pair = new int[]{k, list.size()};

        if (map.containsKey(pair)) {
            return map.get(pair);
        }

        int res = 1;

        for (int i = 0; i < k; i++) {
            res *= list.get(list.size() - i - 1);
        }

        map.put(pair, res);

        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */