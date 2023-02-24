package Algorithm.LeetCode.LeetCode_1352_Product_of_the_Last_K_Numbers;

class ProductOfNumbers {
    private int[] pre;
    private int len;

    public ProductOfNumbers() {
        pre = new int[40001];
        pre[0] = 1;
        len = 0;
    }

    public void add(int num) {
        if (num == 0) {
            len = 0;
            return;
        }

        pre[++len] = num;
        pre[len] *= pre[len - 1];
    }

    public int getProduct(int k) {
        if (len < k) {
            return 0;
        }

        return pre[len] / pre[len - k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */