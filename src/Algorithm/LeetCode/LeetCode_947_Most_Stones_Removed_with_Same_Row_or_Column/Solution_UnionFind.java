package Algorithm.LeetCode.LeetCode_947_Most_Stones_Removed_with_Same_Row_or_Column;

class Solution_UnionFind {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }

        return n - uf.getCount();
    }

    private static class UnionFind {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private final int[] root;
        // 记录树的“重量”
        private final int[] size;

        public UnionFind(int n) {
            this.count = n;
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                root[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                root[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (root[x] != x) {
                // 进行路径压缩
                root[x] = root[root[x]];
                x = root[x];
            }

            return x;
        }

        public int getCount() {
            return count;
        }
    }

}