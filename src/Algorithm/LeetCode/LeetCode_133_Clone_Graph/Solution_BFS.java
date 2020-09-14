package Algorithm.LeetCode.LeetCode_133_Clone_Graph;

import java.util.*;

public class Solution_BFS {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());

        lookup.put(node, clone);

        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Node n : cur.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }

                lookup.get(cur).neighbors.add(lookup.get(n));
            }
        }

        return clone;
    }
}
