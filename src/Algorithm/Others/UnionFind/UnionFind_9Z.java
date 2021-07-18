package Algorithm.Others.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind_9Z {
    private Map<Integer, Integer> father;
    private Map<Integer, Integer> sizeOfSet;
    private int numOfSet = 0;

    public UnionFind_9Z() {
        // 初始化⽗指针，集合⼤⼩，集合数量
        father = new HashMap<>();
        sizeOfSet = new HashMap<>();
        numOfSet = 0;
    }

    public void add(int x) {
        // 点如果已经出现，操作⽆效
        if (father.containsKey(x)) {
            return;
        }

        // 初始化点的⽗亲为 空对象null
        // 初始化该点所在集合⼤⼩为 1
        // 集合数量增加 1
        father.put(x, null);
        sizeOfSet.put(x, 0);
        numOfSet++;
    }

    public int find(int x) {
        // 指针 root 指向被查找的点 x
        int root = x;

        while (father.get(root) != null) {
            root = father.get(root);
        }

        // 将路径上所有点指向根节点 root
        while (x != root) {
            // 暂存 x 原本的⽗亲
            // 将 x 指向根节点
            // x 指针上移⾄ x 的⽗节点
            int originalFather = father.get(x);
            father.put(x, root);
            x = originalFather;
        }

        return root;
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // 将⼀个点的根变成新的根
            // 集合数量减少 1
            // 计算新的根所在集合⼤⼩
            father.put(rootX, rootY);
            numOfSet--;
            sizeOfSet.put(rootX, sizeOfSet.get(rootX) + sizeOfSet.get(rootY));

        }
    }

    public boolean isConnected(int x, int y) {
        // 两个节点连通 等价于 两个节点的根相同
        return find(x) == find(y);
    }

    public int getNumOfSet() {
        // 获得集合数量
        return numOfSet;
    }

    public int getSizeOfSet(int x) {
        // 获得某个点所在集合⼤⼩
        return sizeOfSet.get(find(x));
    }
}
