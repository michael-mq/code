package Algorithm.Others.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    //DFS(深度优先遍历)同样适用于有向图 0->2->1->3->4->5
    void dfsTraversing(int[][] graph) {
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {// 当前顶点没有被访问
                dfsHelper(i, graph, visited);
            }
        }
    }

    void dfsHelper(int i, int[][] graph, int[] visited) {
        visited[i] = 1;// 第i个顶点被访问

        System.out.print(i + " ");

        for (int j = 0; j < graph.length; j++) {
            if (visited[j] == 0 && graph[i][j] == 1) {
                dfsHelper(j, graph, visited);
            }
        }
    }

    //BFS(广度优先遍历)同样适用于有向图 0->2->3->1->4->5
    public void bfsTraversing(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            queue.add(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                System.out.print(cur + " ");

                for (int j = 0; j < graph.length; j++) {
                    if (visited[j] != 1 && graph[cur][j] == 1) {
                        visited[j] = 1;
                        queue.add(j);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Graph foo = new Graph();

        int[][] graph = new int[][]{
                {0, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0}
        };

        foo.dfsTraversing(graph);

        System.out.println();

        foo.bfsTraversing(graph);
    }
}
