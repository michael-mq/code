package Algorithm.LeetCode.LeetCode_695_Max_Area_of_Island;

public class Solution_UF {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);

        int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];

                        if (x > 0 && y > 0 && x < m && y < n && grid[x][y] == 1) {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }

        return uf.getMaxRank();
    }

    public static void main(String[] args) {
        Solution_UF solution = new Solution_UF();

        System.out.println(solution.maxAreaOfIsland(new int[][]{{1, 1}}));
    }
}

class UnionFind {
    private int count;
    private int[] parent;
    private int[] rank;
    private int maxRank;

    public UnionFind(int[][] grid) {
        count = 0;
        maxRank = 0;

        int m = grid.length;
        int n = grid[0].length;

        parent = new int[m * n];
        rank = new int[m * n];

        // Reduce dimension to 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    parent[i * n + j] = i * n + j;
                    rank[i * n + j] = 1;
                    count++;
                    maxRank = 1;
                }
            }
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
                maxRank = Math.max(maxRank, rank[rootX]);
            } else {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
                maxRank = Math.max(maxRank, rank[rootY]);
            }

            count--;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getCount() {
        return count;
    }

    public int getMaxRank() {
        return maxRank;
    }
}
