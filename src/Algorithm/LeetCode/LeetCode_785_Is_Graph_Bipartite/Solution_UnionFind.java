package Algorithm.LeetCode.LeetCode_785_Is_Graph_Bipartite;

public class Solution_UnionFind {
    public boolean isBipartite(int[][] graph) {
        // 初始化并查集
        UnionFind uf = new UnionFind(graph.length);
        // 遍历每个顶点，将当前顶点的所有邻接点进行合并
        for (int i = 0; i < graph.length; i++) {
            int[] adjs = graph[i];
            for (int w : adjs) {
                // 若某个邻接点与当前顶点已经在一个集合中了，说明不是二分图，返回 false。
                if (uf.isConnected(i, w)) {
                    return false;
                }
                uf.union(adjs[0], w);
            }
        }
        return true;
    }

    class UnionFind {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] rank;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            } else {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            }
            count--;
        }

        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }

    public static void main(String[] args) {
        Solution_UnionFind foo = new Solution_UnionFind();

        System.out.println(foo.isBipartite(new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        }));
        System.out.println(foo.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(foo.isBipartite(new int[][]{{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}}));
    }
}
