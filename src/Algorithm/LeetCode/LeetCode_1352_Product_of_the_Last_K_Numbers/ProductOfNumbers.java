package Algorithm.LeetCode.LeetCode_1352_Product_of_the_Last_K_Numbers;

// https://leetcode.cn/problems/product-of-the-last-k-numbers/solutions/101222/zui-hou-k-ge-shu-de-cheng-ji-by-leetcode-solution/
class ProductOfNumbers {
    private int[] pre;
    private int curr;

    public ProductOfNumbers() {
        pre = new int[40001];
        pre[0] = 1;
        curr = 0;
    }

    public void add(int num) {
        if (num == 0) {
            curr = 0;
            return;
        }

        int next = curr + 1;
        pre[next] = num;
        pre[next] *= pre[curr];
        curr++;
    }

//    public void add(int num) {
//        if (num == 0) {
//            curr = 0;
//            return;
//        }
//
//        pre[++curr] = num;
//        pre[curr] *= pre[curr - 1];
//    }

    public int getProduct(int k) {
        if (curr < k) {
            return 0;
        }

        return pre[curr] / pre[curr - k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */