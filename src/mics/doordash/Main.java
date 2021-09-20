package mics.doordash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Given an integer representing number of orders, print all possible valid order paths
public class Main {
    public static void main(String[] args) {
        printValidPaths(5);
    }

    public static void printValidPaths(int n) {
        dfs(n, new HashSet<Integer>(), new HashSet<Integer>(), new ArrayList<String>());
    }

    public static void dfs(int n, Set<Integer> picked, Set<Integer> delivered, List<String> path) {
        if (n * 2 == path.size()) {
            for (String p : path) {
                System.out.print(p + "->");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!picked.contains(i)) {
                picked.add(i);
                String p = "P" + i;
                path.add(p);
                dfs(n, picked, delivered, path);
                path.remove(p);
                picked.remove(i);
            }

            if (picked.contains(i) && !delivered.contains(i)) {
                delivered.add(i);
                String d = "D" + i;
                path.add(d);
                dfs(n, picked, delivered, path);
                path.remove(d);
                delivered.remove(i);
            }
        }
    }
}
