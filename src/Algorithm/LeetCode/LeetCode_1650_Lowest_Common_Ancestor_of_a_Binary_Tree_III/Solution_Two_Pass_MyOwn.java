package Algorithm.LeetCode.LeetCode_1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

// According to first solution of 
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-26/

public class Solution_Two_Pass_MyOwn {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> path_p = getPath(p);
        List<Node> path_q = getPath(q);

        Node ancestor = null;

        for (int i = path_p.size() - 1, j = path_q.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (path_p.get(i) == path_q.get(j)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }

        return ancestor;
    }

    private List<Node> getPath(Node node) {
        List<Node> path = new ArrayList<>();

        while (node != null) {
            path.add(node);
            node = node.parent;
        }

        return path;
    }
}
