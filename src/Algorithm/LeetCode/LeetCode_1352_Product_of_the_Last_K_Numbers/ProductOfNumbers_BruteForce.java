package Algorithm.LeetCode.LeetCode_1352_Product_of_the_Last_K_Numbers;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers_BruteForce {
    private List<Integer> list;

    public ProductOfNumbers_BruteForce() {
        this.list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= list.get(list.size() - i - 1);
        }

        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */