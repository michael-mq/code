package Algorithm.LeetCode.LeetCode_1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.youtube.com/watch?v=gvYVa5ax66U

public class Solution_Two_Iteration_Set {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }

        while (q != null) {
            if (ancestors.contains(q)) {
                return q;
            }

            q = q.parent;
        }

        return null;
    }
}
